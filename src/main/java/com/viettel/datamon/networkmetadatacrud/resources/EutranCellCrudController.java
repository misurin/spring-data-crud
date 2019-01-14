package com.viettel.datamon.networkmetadatacrud.resources;

import com.viettel.datamon.networkmetadatacrud.entity.EutranCell;
import com.viettel.datamon.networkmetadatacrud.repo.EutranCellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crud/eutrancell")
public class EutranCellCrudController extends AbstractCrudController<EutranCell, Long> {

  @Autowired
  private EutranCellRepository eutranCellRepository;

  protected EutranCellCrudController() throws NoSuchMethodException {
  }

  @Override
  JpaRepository<EutranCell, Long> getRepo() {
    return eutranCellRepository;
  }

  @Override
  Class<EutranCell> childEntityType() {
    return EutranCell.class;
  }
}
