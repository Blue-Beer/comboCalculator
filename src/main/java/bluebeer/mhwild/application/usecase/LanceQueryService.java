package bluebeer.mhwild.application.usecase;

import bluebeer.mhwild.domain.Action;
import bluebeer.mhwild.domain.ActionRepository;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LanceQueryService {

  private final ActionRepository actionRepository;

  public List<Action> findLanceActions() throws IOException {
    return null;
  }
}
