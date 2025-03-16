package bluebeer.mhwild.adapter.driving;

import bluebeer.mhwild.application.usecase.LanceQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/lance")
@RequiredArgsConstructor
public class LanceResource {

  private final LanceQueryService lanceQueryService;

//  @GetMapping("ListActions")
//  public ResponseEntity<List<Action>> findLanceActions() throws IOException {
//
//    List<Action> actions = lanceQueryService.findLanceActions();
//
//    return ResponseEntity.status(HttpStatus.OK).contentType(APPLICATION_JSON).body(actions);
//  }


}
