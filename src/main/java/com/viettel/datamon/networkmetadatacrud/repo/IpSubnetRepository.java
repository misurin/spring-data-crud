package com.viettel.datamon.networkmetadatacrud.repo;

import com.viettel.datamon.networkmetadatacrud.entity.IpSubnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IpSubnetRepository extends JpaRepository<IpSubnet, Long>,
    QueryByExampleExecutor<IpSubnet> {

}
