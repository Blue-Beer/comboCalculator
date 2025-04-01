package bluebeer.mhwild.application.usecase.command;

import bluebeer.mhwild.adapter.driven.WeaponActionMapper;
import bluebeer.mhwild.domain.WeaponAction;
import bluebeer.mhwild.domain.WeaponActionUnit;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeaponActionCommandService {

  private final WeaponActionMapper weaponActionMapper;

  public void save(List<WeaponActionUnit> weaponActionUnits, String actionName) {
    WeaponAction newAction = new WeaponAction();
    newAction.setWeaponId(weaponActionUnits.get(0).getWeaponId());
    newAction.setActionName(actionName);
    String actionUnits = weaponActionUnits.stream()
        .map(WeaponActionUnit::getId)
        .reduce((a, b) -> a + "," + b)
        .orElse("");
    newAction.setActionUnits(actionUnits);
    newAction.setActionUnitList(weaponActionUnits);
    weaponActionMapper.insert(newAction);
  }

}
