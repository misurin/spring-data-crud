package com.viettel.datamon.networkmetadatacrud.resources;

import com.viettel.datamon.networkmetadatacrud.entity.IpSubnet;
import com.viettel.datamon.networkmetadatacrud.repo.IpSubnetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crud/ipsubnet")
public class IpSubnetCRUDController extends AbstractCrudController<IpSubnet, Long> {

  @Autowired
  private IpSubnetRepository ipSubnetRepository;

  public IpSubnetCRUDController() throws NoSuchMethodException {
  }

  @Override
  JpaRepository<IpSubnet, Long> getRepo() {
    return ipSubnetRepository;
  }

  @Override
  Class<IpSubnet> childEntityType() {
    return IpSubnet.class;
  }
}
