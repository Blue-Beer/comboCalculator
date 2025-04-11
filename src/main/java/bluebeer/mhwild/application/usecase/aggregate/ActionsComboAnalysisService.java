package bluebeer.mhwild.application.usecase.aggregate;

import bluebeer.mhwild.application.model.WeaponActionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionsComboAnalysisService {

  public ActionsComboAnalysisDto singleAnalysis(ActionsComboQuery query) {
    if (query.getWeaponActions() == null) {
      return null;
    }

    ActionsComboAnalysisDto results = new ActionsComboAnalysisDto();

    for (WeaponActionDto weaponAction : query.getWeaponActions()) {

    }

  }
}
