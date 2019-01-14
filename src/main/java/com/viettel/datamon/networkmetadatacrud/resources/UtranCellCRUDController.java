package com.viettel.datamon.networkmetadatacrud.resources;

import com.viettel.datamon.networkmetadatacrud.entity.UtranCell;
import com.viettel.datamon.networkmetadatacrud.repo.UtranCellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crud/utrancell")
public class UtranCellCRUDController extends AbstractCrudController<UtranCell, Long> {

  @Autowired
  private UtranCellRepository utranCellRepository;

  protected UtranCellCRUDController() throws NoSuchMethodException {}

  @Override
  JpaRepository<UtranCell, Long> getRepo() {
    return utranCellRepository;
  }

  @Override
  Class<UtranCell> childEntityType() {
    return UtranCell.class;
  }
}
