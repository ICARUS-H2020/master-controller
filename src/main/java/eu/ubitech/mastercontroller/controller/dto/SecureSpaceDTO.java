package eu.ubitech.mastercontroller.controller.dto;

public class SecureSpaceDTO {

  private String organization;
  private String table;
  private Long organizationId;
  private Boolean openDataset;
  private Float newVersion;

  public SecureSpaceDTO() {

  }

  public SecureSpaceDTO(String organization, String table, Long organizationid,
                        Boolean openDataset) {
    this.organization = organization.replaceAll("\\s+", "").replace("-", "_").toLowerCase();
    this.organizationId = organizationid;
    this.table = table;
    this.openDataset = openDataset;
  }

  public SecureSpaceDTO(String organization, String table) {
    this.organization = organization.replaceAll("\\s+", "").replace("-", "_").toLowerCase();
    this.table = table;
  }

  public SecureSpaceDTO(String organization, String table, Long organizationid, Boolean openDataset,
                        Float newVersion) {
    this.organization = organization.replaceAll("\\s+", "").replace("-", "_").toLowerCase();
    this.organizationId = organizationid;
    this.table = table;
    this.openDataset = openDataset;
    this.newVersion = newVersion;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public Boolean getOpenDataset() {
    return openDataset;
  }

  public void setOpenDataset(Boolean openDataset) {
    this.openDataset = openDataset;
  }

  public Long getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
  }

  public Float getNewVersion() {
    return newVersion;
  }

  public void setNewVersion(Float newVersion) {
    this.newVersion = newVersion;
  }

}
