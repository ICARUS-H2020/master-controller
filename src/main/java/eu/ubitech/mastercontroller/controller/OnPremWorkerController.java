package eu.ubitech.mastercontroller.controller;

import eu.ubitech.mastercontroller.controller.dto.ObjectKeyDTO;
import eu.ubitech.mastercontroller.service.OnPremWorkerService;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Transactional(rollbackOn = Exception.class)
@RestController
@RequestMapping("/api/v1/worker")
public class OnPremWorkerController {

  @Autowired
  private OnPremWorkerService onPremWorkerService;


  /**
   * Post a Dataset key
   *
   * @param body:               dataaset key
   * @param httpServletRequest: request
   * @return: ok
   */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity postDataassetKey(@RequestBody ObjectKeyDTO body,
                                         HttpServletRequest httpServletRequest) {
    return onPremWorkerService.postDataassetKey(body, httpServletRequest);
  }//EoM Get Dataasset key


  @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
  public ResponseEntity getKey(@PathVariable("id") Long jobId,
                               HttpServletRequest httpServletRequest) {
    return onPremWorkerService.getKey(httpServletRequest, jobId);
  }//EoM Get Dataasset key

  /**
   * Request to decrypt the data. When the user whants to download a dataset then the worker makes a request.
   *
   * @param id:                 dataset id
   * @param httpServletRequest: HttpServletRequest
   * @return: key 1 from key pairs
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity requestToDecryptData(@PathVariable("id") Long id,
                                             HttpServletRequest httpServletRequest) {
    return onPremWorkerService.requestToDecryptData(id, httpServletRequest);
  }//EoM Request to decrypt data

  /**
   * Request to decrypt the data. When the user whants to download an open dataset then the worker makes a request.
   *
   * @param id:                 dataset id
   * @param httpServletRequest: HttpServletRequest
   * @return: ok
   */
  @RequestMapping(value = "/open-data/{id}", method = RequestMethod.GET)
  public ResponseEntity requestToDownloadOpenData(@PathVariable("id") Long id,
                                                  HttpServletRequest httpServletRequest) {
    return onPremWorkerService.requestToDownloadOpenData(id, httpServletRequest);
  }//EoM Request to decrypt data

  /**
   * Remove non completed jobs. When someone close the worker and a job is running then we need to stop it.
   *
   * @param ids                : list with ol data checkin job ids
   * @param httpServletRequest : HttpServletRequest
   * @return ok
   */
  @RequestMapping(value = "/remove-non-completed-jobs", method = RequestMethod.POST)
  public ResponseEntity removeNonCompletedJobs(@RequestBody Set<Long> ids,
                                               HttpServletRequest httpServletRequest) {
    return onPremWorkerService.removeNonCompletedJobs(ids, httpServletRequest);
  }//EoM Remove non completed jobs

  /**
   * Send Mail For SuccessFull Download of a dataset
   *
   * @param name               : dataset name
   * @param httpServletRequest : HttpServletRequest
   * @return : ok
   */
  @RequestMapping(value = "/send-mail", method = RequestMethod.POST)
  public ResponseEntity sendMailForSuccessFullDownload(@RequestBody String name,
                                                       HttpServletRequest httpServletRequest) {
    return onPremWorkerService.sendMailForSuccessFullDownload(name, httpServletRequest);
  }//EoM Remove non completed jobs

  /**
   * Get a datacheckin job file. Creaate a file with all the job informaation.
   *
   * @param id                 job id
   * @param httpServletRequest HttpServletRequest
   * @return file
   */
  @RequestMapping(value = "/datacheckinjob/{id}", method = RequestMethod.GET)
  public ResponseEntity getDatacheckinJobFile(@PathVariable("id") Long id,
                                              HttpServletRequest httpServletRequest) {
    return onPremWorkerService.downloadDatacheckinJobFile(id, httpServletRequest);
  }//EoM


  /**
   * Get worker version. for checkin the version that user has downloaded.
   *
   * @return: version number
   */
  @RequestMapping(value = "/version", method = RequestMethod.GET)
  public ResponseEntity getVersion() {
    return new ResponseEntity("3.2.11", HttpStatus.OK);
  }//EoM

  /**
   * Get worker version. for checkin the version that user has downloaded.
   *
   * @return: version number
   */
  @RequestMapping(value = "/isbusy/{name}", method = RequestMethod.GET)
  public ResponseEntity checkAnalytics(@PathVariable("name") String name,
                                       HttpServletRequest httpServletRequest) {

    return onPremWorkerService.checkAnalytics(name, httpServletRequest);
  }//EoM

}//EoC
