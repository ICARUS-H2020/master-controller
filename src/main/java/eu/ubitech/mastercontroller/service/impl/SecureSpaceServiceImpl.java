package eu.ubitech.mastercontroller.service.impl;

import eu.ubitech.mastercontroller.controller.dto.SecureSpaceDTO;
import eu.ubitech.mastercontroller.service.SecureSpaceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SecureSpaceServiceImpl implements SecureSpaceService {

  private static final Logger LOGGER = LogManager.getLogger(SecureSpaceServiceImpl.class);
  private static final RestTemplate restTemplate = new RestTemplate();
  @Value("${icarus.securespace.url}")
  private String secureSpaceURL;

  @Override
  public void pingSecureSpace(String name, String id, Long organizationid, Boolean openDataset) {
    try {
      SecureSpaceDTO secureSpaceDTO = new SecureSpaceDTO(name, id, organizationid, openDataset);
      HttpEntity requestEntity = new HttpEntity(secureSpaceDTO, null);
      ResponseEntity<String> response = restTemplate.exchange(secureSpaceURL +
              "/secure-space-worker/transfer", HttpMethod.POST,
          requestEntity, String.class);

      if (!(null != response && response.getStatusCode().is2xxSuccessful())) {
        LOGGER.error("Something went wrong with ping secure space");
      }

    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }

  @Override
  public void pingSecureSpaceForReplace(String name, String id, Long organizationid,
                                        Boolean openDataset, Float newVersion) {
    try {
      SecureSpaceDTO secureSpaceDTO =
          new SecureSpaceDTO(name, id, organizationid, openDataset, newVersion);
      LOGGER.info(secureSpaceDTO.getOrganizationId());
      HttpEntity requestEntity = new HttpEntity(secureSpaceDTO, null);
      ResponseEntity<String> response = restTemplate.exchange(secureSpaceURL +
              "/secure-space-worker/transfer/update/replace", HttpMethod.POST,
          requestEntity, String.class);
      if (null != response && response.getStatusCode().is2xxSuccessful()) {
        LOGGER.info("pingSecureSpaceForReplace {}", response.getStatusCode());
      } else {
        LOGGER.error("pingSecureSpaceForReplace {}", response.getStatusCode());
      }

    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }

  @Override
  public void pingSecureSpaceForAppend(String name, String id, Long organizationid,
                                       Boolean openDataset, Float newVersion) {
    try {
      SecureSpaceDTO secureSpaceDTO =
          new SecureSpaceDTO(name, id, organizationid, openDataset, newVersion);
      LOGGER.info(secureSpaceDTO.getOrganizationId());
      HttpEntity requestEntity = new HttpEntity(secureSpaceDTO, null);
      ResponseEntity<String> response = restTemplate.exchange(secureSpaceURL +
              "/secure-space-worker/transfer/update/append", HttpMethod.POST,
          requestEntity, String.class);
      if (null != response && response.getStatusCode().is2xxSuccessful()) {
        LOGGER.info("pingSecureSpaceForAppend {}", response.getStatusCode());
      } else {
        LOGGER.error("pingSecureSpaceForAppend {}", response.getStatusCode());
      }

    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }

  @Override
  public void pingSecureSpaceForDelete(String name, String id) {
    try {
      SecureSpaceDTO secureSpaceDTO = new SecureSpaceDTO(name, "dataset_" + id);
      LOGGER.info(secureSpaceDTO.getOrganizationId());
      HttpEntity requestEntity = new HttpEntity(secureSpaceDTO, null);
      ResponseEntity<String> response = restTemplate.exchange(secureSpaceURL +
              "/secure-space-worker/transfer", HttpMethod.DELETE,
          requestEntity, String.class);
      if (null != response && response.getStatusCode().is2xxSuccessful()) {
        LOGGER.info("pingSecureSpaceForDelete {}", response.getStatusCode());
      } else {
        LOGGER.error("pingSecureSpaceForDelete {}", response.getStatusCode());
      }

    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }

  @Override
  public void pingSecureSpaceForOrganizationRegistration(String organizationName) {
    try {
      ResponseEntity response = restTemplate.exchange(secureSpaceURL +
              "/secure-space-worker/protection/createAndSetPolitics/" + organizationName,
          HttpMethod.POST,
          null, String.class);
      if (null != response && response.getStatusCode().is2xxSuccessful()) {
        LOGGER.info("pingSecureSpaceForOrganizationRegistration {}", response.getStatusCode());
      } else {
        LOGGER.error("pingSecureSpaceForOrganizationRegistration {}", response.getStatusCode());
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
    }

  }
}
