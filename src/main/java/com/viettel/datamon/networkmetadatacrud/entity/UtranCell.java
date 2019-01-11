package com.viettel.datamon.networkmetadatacrud.entity;


import javax.persistence.*;

@Entity
@Table(name = "cell_rnc")
public class UtranCell {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "rnc_name")
  private String rncName;
  @Column(name = "rnc_id")
  private Long rncId;
  private Long lac;
  private Long rac;
  private String station;
  @Column(name = "cell_name")
  private String cellName;
  private Long cellId;
  @Column(name = "arfcn_dl")
  private Long arfcnDl;
  @Column(name = "arfcn_ul")
  private Long arfcnUl;
  private Long sac;
  private Long psc;
  private Double longitude;
  private Double latitude;
  private String district;
  private String province;
  private Double tilt;
  private Double azimuth;
  @Column(name = "station_ip")
  private String stationIp;
  private String address;
  @Column(name = "rbs_downlink_port")
  private Long rbsDownlinkPort;
  @Column(name = "rbs_uplink_port")
  private Long rbsUplinkPort;
  @Column(name = "last_update")
  private String lastUpdate;
  private String region;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRncName() {
    return rncName;
  }

  public void setRncName(String rncName) {
    this.rncName = rncName;
  }

  public Long getRncId() {
    return rncId;
  }

  public void setRncId(Long rncId) {
    this.rncId = rncId;
  }

  public Long getLac() {
    return lac;
  }

  public void setLac(Long lac) {
    this.lac = lac;
  }

  public Long getRac() {
    return rac;
  }

  public void setRac(Long rac) {
    this.rac = rac;
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

  public Long getArfcnDl() {
    return arfcnDl;
  }

  public void setArfcnDl(Long arfcnDl) {
    this.arfcnDl = arfcnDl;
  }

  public Long getArfcnUl() {
    return arfcnUl;
  }

  public void setArfcnUl(Long arfcnUl) {
    this.arfcnUl = arfcnUl;
  }

  public Long getSac() {
    return sac;
  }

  public void setSac(Long sac) {
    this.sac = sac;
  }

  public Long getPsc() {
    return psc;
  }

  public void setPsc(Long psc) {
    this.psc = psc;
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

  public String getStationIp() {
    return stationIp;
  }

  public void setStationIp(String stationIp) {
    this.stationIp = stationIp;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getRbsDownlinkPort() {
    return rbsDownlinkPort;
  }

  public void setRbsDownlinkPort(Long rbsDownlinkPort) {
    this.rbsDownlinkPort = rbsDownlinkPort;
  }

  public Long getRbsUplinkPort() {
    return rbsUplinkPort;
  }

  public void setRbsUplinkPort(Long rbsUplinkPort) {
    this.rbsUplinkPort = rbsUplinkPort;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }
}
