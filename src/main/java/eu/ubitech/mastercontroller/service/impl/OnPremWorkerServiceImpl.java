package eu.ubitech.mastercontroller.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.ubitech.mastercontroller.controller.dto.ObjectKeyDTO;
import eu.ubitech.mastercontroller.service.OnPremWorkerService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OnPremWorkerServiceImpl implements OnPremWorkerService {

  private static final Logger LOGGER = LogManager.getLogger(OnPremWorkerServiceImpl.class);
  private static final RestTemplate restTemplate = new RestTemplate();
  @Qualifier("webApplicationContext")
  @Autowired
  private ResourceLoader resourceLoader;
  @Value("${icarus.eng.url}")
  private String engURL;

  @Override
  public ResponseEntity postDataassetKey(ObjectKeyDTO body, HttpServletRequest httpServletRequest) {
    if (httpServletRequest.getHeader("Token") == null) {
      return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    BufferedReader br = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Resource model = resourceLoader.getResource("classpath:config.json");
      br =
          new BufferedReader(new InputStreamReader(model.getInputStream(), StandardCharsets.UTF_8));
      JsonNode jsonNode = objectMapper.readTree(br);
      String token = jsonNode.get("worker_key").asText();
      if (!httpServletRequest.getHeader("Token").equals(token)) {
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }


      LOGGER.info("body.getKey()");


      return new ResponseEntity(null, HttpStatus.OK);


    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (Exception e) {
          LOGGER.error(e.getMessage(), e);
        }
      }
    }
  }//EoM

  @Override
  public ResponseEntity getKey(HttpServletRequest httpServletRequest, Long jobId) {
    if (httpServletRequest.getHeader("Token") == null) {
      return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    BufferedReader br = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Resource model = resourceLoader.getResource("classpath:config.json");
      br =
          new BufferedReader(new InputStreamReader(model.getInputStream(), StandardCharsets.UTF_8));
      JsonNode jsonNode = objectMapper.readTree(br);
      String token = jsonNode.get("worker_key").asText();
      if (!httpServletRequest.getHeader("Token").equals(token)) {
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }


      return new ResponseEntity(
          objectMapper.readTree("{\"update\":\"" + "safads%$#^@!$Y7618eRFQQ$" + "\"}"),
          HttpStatus.OK);

    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (Exception e) {
          LOGGER.error(e.getMessage(), e);
        }
      }
    }
  }//Eo

  @Override
  public ResponseEntity removeNonCompletedJobs(Set<Long> ids,
                                               HttpServletRequest httpServletRequest) {
    if (httpServletRequest.getHeader("Token") == null) {
      return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    BufferedReader br = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Resource model = resourceLoader.getResource("classpath:config.json");
      br =
          new BufferedReader(new InputStreamReader(model.getInputStream(), StandardCharsets.UTF_8));
      JsonNode jsonNode = objectMapper.readTree(br);
      String token = jsonNode.get("worker_key").asText();
      if (!httpServletRequest.getHeader("Token").equals(token)) {
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      //gia ola ta ids na vro ta execution states kai ta datacheckin jobs
      if (ids.size() > 0) {
        return new ResponseEntity(null, HttpStatus.OK);
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (Exception e) {
          LOGGER.error(e.getMessage(), e);
        }
      }
    }
    return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }//EoM

  @Override
  public ResponseEntity requestToDecryptData(Long id, HttpServletRequest httpServletRequest) {
    LOGGER.info("Request to download data with dataset id {}", id);
    if (httpServletRequest.getHeader("Token") == null) {
      return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    BufferedReader br = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Resource model = resourceLoader.getResource("classpath:config.json");
      br =
          new BufferedReader(new InputStreamReader(model.getInputStream(), StandardCharsets.UTF_8));
      JsonNode jsonNode = objectMapper.readTree(br);
      String token = jsonNode.get("worker_key").asText();
      if (!httpServletRequest.getHeader("Token").equals(token)) {
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }

      LOGGER.info("Check if has access to dataset {}", true);

      if (true) {
        LOGGER.info("Check here");

        return new ResponseEntity(null, HttpStatus.OK);
      }

    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (Exception e) {
          LOGGER.error(e.getMessage(), e);
        }
      }
    }
    return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }//EoM

  @Override
  public ResponseEntity requestToDownloadOpenData(Long id, HttpServletRequest httpServletRequest) {
    LOGGER.info("Request to download open data with dataset id {}", id);

    if (httpServletRequest.getHeader("Token") == null) {
      return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    BufferedReader br = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Resource model = resourceLoader.getResource("classpath:config.json");
      br =
          new BufferedReader(new InputStreamReader(model.getInputStream(), StandardCharsets.UTF_8));
      JsonNode jsonNode = objectMapper.readTree(br);
      String token = jsonNode.get("worker_key").asText();
      if (!httpServletRequest.getHeader("Token").equals(token)) {
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity(null, HttpStatus.OK);

    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (Exception e) {
          LOGGER.error(e.getMessage(), e);
        }
      }
    }
  }//EoM

  @Override
  public ResponseEntity sendMailForSuccessFullDownload(String name,
                                                       HttpServletRequest httpServletRequest) {
    if (httpServletRequest.getHeader("Token") == null) {
      return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    BufferedReader br = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Resource model = resourceLoader.getResource("classpath:config.json");
      br =
          new BufferedReader(new InputStreamReader(model.getInputStream(), StandardCharsets.UTF_8));
      JsonNode jsonNode = objectMapper.readTree(br);
      String token = jsonNode.get("worker_key").asText();
      if (!httpServletRequest.getHeader("Token").equals(token)) {
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity(null, HttpStatus.OK);
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (Exception e) {
          LOGGER.error(e.getMessage(), e);
        }
      }
    }
  }//EoM

  @Override
  public ResponseEntity downloadDatacheckinJobFile(Long datacheckinjobId,
                                                   HttpServletRequest request) {
    return new ResponseEntity(null, HttpStatus.OK);
  }

  @Override
  public ResponseEntity checkAnalytics(String name, HttpServletRequest httpServletRequest) {

    try {
      LOGGER.info("Check Dataset For Analytics: " + name);

      HttpHeaders headers = new HttpHeaders();
      headers.add("Cookie",
          "auth_token=" + httpServletRequest.getHeader("Authorization").substring(7));

      ResponseEntity<JsonNode> response =
          restTemplate.exchange(engURL + "/" + name + "/isbusy", HttpMethod.GET,
              new HttpEntity<String>(headers), JsonNode.class);

      if (null != response && response.getStatusCode().is2xxSuccessful()) {
        LOGGER.info(response.getStatusCode());
        LOGGER.info(response.getBody());
        return new ResponseEntity(response.getBody(), HttpStatus.OK);
      } else {
        LOGGER.error("Something went wrong {}", response.getStatusCode());
      }
    } catch (Exception e) {
      LOGGER.error("Check analytics FAILED");
      LOGGER.error(e.getMessage());
    }

    return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

  }
}
