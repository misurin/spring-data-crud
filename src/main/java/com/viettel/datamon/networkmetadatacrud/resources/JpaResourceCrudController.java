package com.viettel.datamon.networkmetadatacrud.resources;

import com.viettel.datamon.networkmetadatacrud.util.ConversionUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


public abstract class JpaResourceCrudController<E, K> {

  private static final Logger LOGGER = LoggerFactory.getLogger(JpaResourceCrudController.class);
  private static final Integer DEFAULT_PAGE = 0;
  private static final Integer DEFAULT_SIZE = 10;

  private static final ExampleMatcher MATCHER = ExampleMatcher.matching()
      .withIgnoreCase()
      .withIgnoreNullValues()
      .withStringMatcher(StringMatcher.CONTAINING);

  private Constructor<E> constructor = childEntityType().getConstructor();

  protected JpaResourceCrudController() throws NoSuchMethodException {
  }

  abstract JpaRepository<E, K> getRepo();

  E createExampleInstance(Map<String, String> filterMap)
      throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
    E instance = constructor.newInstance();
    for (Map.Entry<String, String> e : filterMap.entrySet()) {
      Object val = e.getValue();
      Field f = childEntityType().getDeclaredField(e.getKey());
      f.setAccessible(true);
      LOGGER.info("Setting field {} type {} with value {}", f.getName(),
          f.getType().getName(), val);
      if (ConversionUtils.isNumericType(f.getType())) {
        val = ConversionUtils.stringToDecimal(f.getType(), (String) val);
      }
      f.set(instance, f.getType().cast(val));
    }
    return instance;
  }

  abstract Class<E> childEntityType();

  @GetMapping("/{id}")
  public Optional<E> get(@PathVariable("id") K id) {
    return getRepo().findById(id);
  }

  @GetMapping("/getByIds")
  public List<E> get(@RequestParam("ids") List<K> ids) {
    return getRepo().findAllById(ids);
  }

  @GetMapping("")
  public ResponseEntity<Page<E>> get(
      @RequestParam(value = "filter", required = false) String filterString,
      @RequestParam(value = "page", required = false) Integer page,
      @RequestParam(value = "size", required = false) Integer size
  ) {
    page = page == null ? DEFAULT_PAGE : page;
    size = size == null ? DEFAULT_SIZE : size;
    LOGGER.info("Params {}, {}", page, size);
    E s;
    try {
      Map<String, String> filterMap = parseFilterString(filterString);
      if (filterMap.isEmpty()) {
        return new ResponseEntity<>(getRepo().findAll(PageRequest.of(page, size)), HttpStatus.OK);
      } else {
        s = createExampleInstance(filterMap);
        return new ResponseEntity<>(
            getRepo().findAll(Example.of(s, MATCHER), PageRequest.of(page, size)), HttpStatus.OK);
      }
    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (NoSuchFieldException | InvalidPropertiesFormatException e) {
      LOGGER.warn(e.toString());
      return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  private static Map<String, String> parseFilterString(String filterString)
      throws InvalidPropertiesFormatException {
    if (filterString != null) {
      String[] filters = filterString.split(",");
      if (filters.length > 0) {
        Map<String, String> filterMap = new HashMap<>(filters.length);
        for (String token : filters) {
          String[] pair = token.split(":");
          if (pair.length == 2) {
            filterMap.put(pair[0], pair[1]);
          } else {
            throw new InvalidPropertiesFormatException(
                "Invalid filter string format: " + filterString);
          }
        }
        return filterMap;
      }
    }

    return Collections.EMPTY_MAP;
  }
}
