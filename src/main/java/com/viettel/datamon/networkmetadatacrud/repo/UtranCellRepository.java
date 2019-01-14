package com.viettel.datamon.networkmetadatacrud.repo;

import com.viettel.datamon.networkmetadatacrud.entity.UtranCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UtranCellRepository extends JpaRepository<UtranCell, Long> {

}
