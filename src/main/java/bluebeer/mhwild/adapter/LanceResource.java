package bluebeer.mhwild.adapter;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import bluebeer.mhwild.application.usecase.LanceQueryService;
import bluebeer.mhwild.domain.Action;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/lance")
@RequiredArgsConstructor
public class LanceResource {

  private final LanceQueryService lanceQueryService;

  @GetMapping("ListActions")
  public ResponseEntity<List<Action>> findLanceActions() throws IOException {

    List<Action> actions = lanceQueryService.findLanceActions();

    return ResponseEntity.status(HttpStatus.OK).contentType(APPLICATION_JSON).body(actions);
  }


}
