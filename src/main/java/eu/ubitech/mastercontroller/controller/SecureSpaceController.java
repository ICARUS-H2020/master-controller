package eu.ubitech.mastercontroller.controller;

import eu.ubitech.mastercontroller.controller.dto.SecureSpaceDTO;
import eu.ubitech.mastercontroller.service.SecureSpaceService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Transactional(rollbackOn = Exception.class)
@RestController
@RequestMapping("/api/v1/secure-space")
public class SecureSpaceController {

  @Autowired
  private SecureSpaceService secureSpaceService;

  @RequestMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
  public ResponseEntity pingSecureSpace(@RequestBody SecureSpaceDTO secureSpaceDTO,
                                        @PathVariable String id) {
    secureSpaceService.pingSecureSpace(secureSpaceDTO.getTable(), id,
        secureSpaceDTO.getOrganizationId(), secureSpaceDTO.getOpenDataset());

    return new ResponseEntity(HttpStatus.ACCEPTED);

  }

  @RequestMapping(value = "/replace/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
  public ResponseEntity pingSecureSpaceReplace(@RequestBody SecureSpaceDTO secureSpaceDTO,
                                               @PathVariable String id) {
    secureSpaceService.pingSecureSpaceForReplace(secureSpaceDTO.getTable(), id,
        secureSpaceDTO.getOrganizationId(), secureSpaceDTO.getOpenDataset(),
        secureSpaceDTO.getNewVersion());

    return new ResponseEntity(HttpStatus.ACCEPTED);

  }

  @RequestMapping(value = "/append/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
  public ResponseEntity pingSecureSpaceAppend(@RequestBody SecureSpaceDTO secureSpaceDTO,
                                              @PathVariable String id) {
    secureSpaceService.pingSecureSpaceForAppend(secureSpaceDTO.getTable(), id,
        secureSpaceDTO.getOrganizationId(), secureSpaceDTO.getOpenDataset(),
        secureSpaceDTO.getNewVersion());

    return new ResponseEntity(HttpStatus.ACCEPTED);

  }

  @RequestMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
  public ResponseEntity pingSecureSpaceDelete(@RequestBody SecureSpaceDTO secureSpaceDTO,
                                              @PathVariable String id) {

    secureSpaceService.pingSecureSpaceForDelete(secureSpaceDTO.getTable(), id);
    return new ResponseEntity(HttpStatus.ACCEPTED);

  }

  @RequestMapping(value = "/organization/{name}/", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
  public ResponseEntity pingSecureSpaceNewOrganization(@PathVariable String name) {

    secureSpaceService.pingSecureSpaceForOrganizationRegistration(name);
    return new ResponseEntity(HttpStatus.ACCEPTED);

  }

}//EoC
