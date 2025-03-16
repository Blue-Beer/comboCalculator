package bluebeer.mhwild.application.factory;

import bluebeer.mhwild.domain.WeaponActionUnit;
import bluebeer.mhwild.domain.lance.LanceActionUnit;

public class WeaponActionUnitFactory {

  public static WeaponActionUnit createWeapon(String weaponType) {
    return switch (weaponType) {
//      case "GREAT_SWORD" -> new GreatSwordAction();
      case "Lance" -> new LanceActionUnit();
      default -> throw new IllegalArgumentException("未知武器类型：" + weaponType);
    };
  }
}