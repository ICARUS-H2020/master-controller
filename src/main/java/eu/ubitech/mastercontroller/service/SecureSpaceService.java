package eu.ubitech.mastercontroller.service;

public interface SecureSpaceService {

  void pingSecureSpace(String name, String id, Long organizationid, Boolean openDataset);

  void pingSecureSpaceForReplace(String name, String id, Long organizationid,
                                 Boolean openDataset, Float newVersion);

  void pingSecureSpaceForAppend(String name, String id, Long organizationid,
                                Boolean openDataset, Float newVersion);

  void pingSecureSpaceForDelete(String name, String id);

  void pingSecureSpaceForOrganizationRegistration(String organizationName);

}
