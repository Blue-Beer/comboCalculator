package bluebeer.mhwild.application.usecase.query;

import bluebeer.mhwild.adapter.driven.database.weaponAction.WeaponActionPo;
import bluebeer.mhwild.application.model.WeaponActionDto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeaponActionQueryService {

  private final WeaponActionGetService weaponActionGetService;

  public List<WeaponActionDto> getWeaponActions(String weaponId) {

    List<WeaponActionDto> result = new ArrayList<>();

    List<WeaponActionPo> weaponActions = weaponActionGetService.getWeaponActions(weaponId);

    for (WeaponActionPo weaponActionPo : weaponActions) {
      result.add(weaponActionGetService.getUnits(weaponActionPo));
    }

    return result;
  }

  public WeaponActionDto getWeaponAction(String weaponId, String actionId) {

    WeaponActionPo weaponActionPo = weaponActionGetService.getWeaponAction(weaponId, actionId);

    return weaponActionGetService.getUnits(weaponActionPo);
  }
}
