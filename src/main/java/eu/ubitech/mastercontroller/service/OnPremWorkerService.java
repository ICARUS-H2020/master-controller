package eu.ubitech.mastercontroller.service;

import eu.ubitech.mastercontroller.controller.dto.ObjectKeyDTO;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface OnPremWorkerService {
  ResponseEntity postDataassetKey(ObjectKeyDTO body, HttpServletRequest httpServletRequest);

  ResponseEntity getKey(HttpServletRequest httpServletRequest, Long jobId);

  ResponseEntity removeNonCompletedJobs(Set<Long> ids, HttpServletRequest httpServletRequest);

  ResponseEntity requestToDecryptData(Long id, HttpServletRequest httpServletRequest);

  ResponseEntity requestToDownloadOpenData(Long id, HttpServletRequest httpServletRequest);

  ResponseEntity sendMailForSuccessFullDownload(String name, HttpServletRequest httpServletRequest);

  ResponseEntity downloadDatacheckinJobFile(Long datacheckinjobId, HttpServletRequest request);

  ResponseEntity checkAnalytics(String name, HttpServletRequest httpServletRequest);


}
