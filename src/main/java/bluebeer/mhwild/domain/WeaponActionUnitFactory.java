package bluebeer.mhwild.domain;

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