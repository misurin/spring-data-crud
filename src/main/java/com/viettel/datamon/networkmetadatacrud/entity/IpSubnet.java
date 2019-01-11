package com.viettel.datamon.networkmetadatacrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ip_subnets")
public class IpSubnet {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "node_id")
  private String nodeId;
  @Column(name = "node_type")
  private String nodeType;
  private String vendor;
  private String zone;
  private String subnet;
  @Column(name = "ip_address")
  private String ipAddress;
  @Column(name = "interface")
  private String iface;
  @Column(name = "is_full")
  private Long isFull;

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public String getNodeType() {
    return nodeType;
  }

  public void setNodeType(String nodeType) {
    this.nodeType = nodeType;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public String getZone() {
    return zone;
  }

  public void setZone(String zone) {
    this.zone = zone;
  }

  public String getSubnet() {
    return subnet;
  }

  public void setSubnet(String subnet) {
    this.subnet = subnet;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getIsFull() {
    return isFull;
  }

  public void setIsFull(Long isFull) {
    this.isFull = isFull;
  }

  public String getIface() {
    return iface;
  }

  public void setIface(String iface) {
    this.iface = iface;
  }

  @Override
  public String toString() {
    return "IpSubnet{" +
        "id=" + id +
        ", nodeId='" + nodeId + '\'' +
        ", nodeType='" + nodeType + '\'' +
        ", vendor='" + vendor + '\'' +
        ", zone='" + zone + '\'' +
        ", subnet='" + subnet + '\'' +
        ", ipAddress='" + ipAddress + '\'' +
        ", isFull=" + isFull +
        '}';
  }
}
