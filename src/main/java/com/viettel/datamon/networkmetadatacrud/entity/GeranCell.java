package com.viettel.datamon.networkmetadatacrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cell_bsc")
public class GeranCell {

  @Id
  @GeneratedValue
  private Integer id;
  @Column(name = "bsc_name")
  private String bscName;
  private Integer lac;
  private String station;
  @Column(name = "cell_name")
  private String cellName;
  @Column(name = "cell_id")
  private Long cellId;
  @Column(name = "arfcn_dl")
  private Integer arfcnDl;
  @Column(name = "arfcn_ul")
  private Integer arfcnUl;
  private Integer sac;
  private Integer bsic;
  private Double longitude;
  private Double latitude;
  private String district;
  private String province;
  private Double tilt;
  private Double azimuth;
  private String address;
  @Column(name = "last_update")
  private Long lastUpdate;
  private String region;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBscName() {
    return bscName;
  }

  public void setBscName(String bscName) {
    this.bscName = bscName;
  }

  public Integer getLac() {
    return lac;
  }

  public void setLac(Integer lac) {
    this.lac = lac;
  }

  public String getStation() {
    return station;
  }

  public void setStation(String station) {
    this.station = station;
  }

  public String getCellName() {
    return cellName;
  }

  public void setCellName(String cellName) {
    this.cellName = cellName;
  }

  public Long getCellId() {
    return cellId;
  }

  public void setCellId(Long cellId) {
    this.cellId = cellId;
  }

  public Integer getArfcnDl() {
    return arfcnDl;
  }

  public void setArfcnDl(Integer arfcnDl) {
    this.arfcnDl = arfcnDl;
  }

  public Integer getArfcnUl() {
    return arfcnUl;
  }

  public void setArfcnUl(Integer arfcnUl) {
    this.arfcnUl = arfcnUl;
  }

  public Integer getSac() {
    return sac;
  }

  public void setSac(Integer sac) {
    this.sac = sac;
  }

  public Integer getBsic() {
    return bsic;
  }

  public void setBsic(Integer bsic) {
    this.bsic = bsic;
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

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Double getTilt() {
    return tilt;
  }

  public void setTilt(Double tilt) {
    this.tilt = tilt;
  }

  public Double getAzimuth() {
    return azimuth;
  }

  public void setAzimuth(Double azimuth) {
    this.azimuth = azimuth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Long lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }
}
