package com.viettel.datamon.networkmetadatacrud.repo;

import com.viettel.datamon.networkmetadatacrud.entity.GeranCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeranCellRepository extends JpaRepository<GeranCell, Long> {
}
