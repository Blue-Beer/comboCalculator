package bluebeer.mhwild.application.usecase.query;

import bluebeer.mhwild.adapter.driven.database.weaponAction.WeaponActionPo;
import bluebeer.mhwild.application.model.WeaponActionDto;
import java.util.List;

public interface WeaponActionGetService {

  List<WeaponActionPo> getWeaponActions(String weaponId);

  WeaponActionDto getUnits(WeaponActionPo weaponActions);

  WeaponActionPo getWeaponAction(String weaponId, String actionId);
}
