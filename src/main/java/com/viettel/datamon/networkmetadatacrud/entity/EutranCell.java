package com.viettel.datamon.networkmetadatacrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cell_enodeb")
public class EutranCell {

  @Id
  @GeneratedValue
  private Integer id;
  @Column(name = "cell_id")
  private Integer cellId;
  @Column(name = "cell_name")
  private String cellName;
  @Column(name = "update_time")
  private Long updateTime;
  @Column(name = "enodeb_name")
  private String enodebName;
  @Column(name = "enodeb_id")
  private Integer enodebId;
  private Double longitude;
  private Double latitude;
  @Column(name = "province_code")
  private String provinceCode;
  private String province;
  private String district;
  private String ward;
  @Column(name = "service_ip")
  private String serviceIp;
  @Column(name = "service_subnet_mask")
  private String serviceSubnetMask;
  private String region;
  private Double azimuth;
  private Double tilt;
  private Integer bandwidth;
  private Integer pci;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCellId() {
    return cellId;
  }

  public void setCellId(Integer cellId) {
    this.cellId = cellId;
  }

  public String getCellName() {
    return cellName;
  }

  public void setCellName(String cellName) {
    this.cellName = cellName;
  }

  public Long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  public String getEnodebName() {
    return enodebName;
  }

  public void setEnodebName(String enodebName) {
    this.enodebName = enodebName;
  }

  public Integer getEnodebId() {
    return enodebId;
  }

  public void setEnodebId(Integer enodebId) {
    this.enodebId = enodebId;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getWard() {
    return ward;
  }

  public void setWard(String ward) {
    this.ward = ward;
  }

  public String getServiceIp() {
    return serviceIp;
  }

  public void setServiceIp(String serviceIp) {
    this.serviceIp = serviceIp;
  }

  public String getServiceSubnetMask() {
    return serviceSubnetMask;
  }

  public void setServiceSubnetMask(String serviceSubnetMask) {
    this.serviceSubnetMask = serviceSubnetMask;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public Double getAzimuth() {
    return azimuth;
  }

  public void setAzimuth(Double azimuth) {
    this.azimuth = azimuth;
  }

  public Double getTilt() {
    return tilt;
  }

  public void setTilt(Double tilt) {
    this.tilt = tilt;
  }

  public Integer getBandwidth() {
    return bandwidth;
  }

  public void setBandwidth(Integer bandwidth) {
    this.bandwidth = bandwidth;
  }

  public Integer getPci() {
    return pci;
  }

  public void setPci(Integer pci) {
    this.pci = pci;
  }
}
