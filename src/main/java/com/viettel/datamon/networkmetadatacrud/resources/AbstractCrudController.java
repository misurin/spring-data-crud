package com.viettel.datamon.networkmetadatacrud.resources;

import com.viettel.datamon.networkmetadatacrud.util.ConversionUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public abstract class AbstractCrudController<E, K> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCrudController.class);
  private static final Integer DEFAULT_PAGE = 0;
  private static final Integer DEFAULT_SIZE = 10;

  private String[] entityFieldArray;

  private static final ExampleMatcher MATCHER = ExampleMatcher.matching()
      .withIgnoreCase()
      .withIgnoreNullValues()
      .withStringMatcher(StringMatcher.CONTAINING);

  private Constructor<E> constructor = childEntityType().getConstructor();

  protected AbstractCrudController() throws NoSuchMethodException {
    entityFieldArray = getEntityFieldList();
  }

  abstract JpaRepository<E, K> getRepo();

  private E createExampleInstance(Map<String, String> filterMap)
      throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
    E instance = constructor.newInstance();
    for (Map.Entry<String, String> e : filterMap.entrySet()) {
      Object val = e.getValue();
      Field f = childEntityType().getDeclaredField(e.getKey());
      f.setAccessible(true);
      LOGGER.debug("Setting field {} type {} with value {}", f.getName(),
          f.getType().getName(), val);
      if (ConversionUtils.isNumericType(f.getType())) {
        val = ConversionUtils.stringToDecimal(f.getType(), (String) val);
      }
      f.set(instance, f.getType().cast(val));
    }
    return instance;
  }

  abstract Class<E> childEntityType();

  private String[] getEntityFieldList() {
    Field[] fields = childEntityType().getDeclaredFields();
    String[] fNames = new String[fields.length];
    for (int i = 0; i < fields.length; i++) {
      fNames[i] = fields[i].getName();
    }
    return fNames;
  }


  @GetMapping("/{id}")
  public Optional<E> get(@PathVariable("id") K id) {
    return getRepo().findById(id);
  }

  @GetMapping("/getByIds")
  public List<E> get(@RequestParam("ids") List<K> ids) {
    return getRepo().findAllById(ids);
  }

  @GetMapping("")
  public ResponseEntity get(
      HttpServletRequest request,
      @RequestParam(value = "filter", required = false) String filterString,
      @RequestParam(value = "page", required = false) Integer page,
      @RequestParam(value = "size", required = false) Integer size
  ) {
    LOGGER.debug("Got request={} from client={} with params: filter={}, page={}, size={}",
        request.getRequestURL(), request.getRemoteAddr(), filterString, page, size);
    page = page == null ? DEFAULT_PAGE : page;
    size = size == null ? DEFAULT_SIZE : size;
    E s;
    ResponseEntity responseEntity;
    try {
      Map<String, String> filterMap = parseFilterString(filterString);
      if (filterMap.isEmpty()) {
        responseEntity = new ResponseEntity<>(getRepo().findAll(PageRequest.of(page, size)),
            HttpStatus.OK);
      } else {
        s = createExampleInstance(filterMap);
        responseEntity = new ResponseEntity<>(
            getRepo().findAll(Example.of(s, MATCHER), PageRequest.of(page, size)), HttpStatus.OK);
      }
    } catch (NoSuchFieldException e) {
      String errorMsg = "No such field " + e.getMessage() + ", field must be in " + Arrays
          .toString(entityFieldArray);
      logError(request.getRemoteAddr(), e.getMessage());
      responseEntity = new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
    } catch (InvalidPropertiesFormatException e) {
      logError(request.getRemoteAddr(), e.getMessage());
      responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
      logError(request.getRemoteAddr(), e.getCause().toString());
      responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return responseEntity;
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
    return Collections.emptyMap();
  }

  private void logError(String fromClient, String errorMsg) {
    LOGGER.warn("Invalid request from client {}, error message {}", fromClient, errorMsg);
  }
}
