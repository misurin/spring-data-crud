package com.viettel.datamon.networkmetadatacrud.resources;

import com.viettel.datamon.networkmetadatacrud.entity.GeranCell;
import com.viettel.datamon.networkmetadatacrud.repo.GeranCellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crud/gerancell")
public class GeranCellCrudController extends AbstractCrudController<GeranCell, Long> {

  @Autowired
  private GeranCellRepository geranCellRepository;

  protected GeranCellCrudController() throws NoSuchMethodException {
  }

  @Override
  JpaRepository<GeranCell, Long> getRepo() {
    return geranCellRepository;
  }

  @Override
  Class<GeranCell> childEntityType() {
    return GeranCell.class;
  }
}
