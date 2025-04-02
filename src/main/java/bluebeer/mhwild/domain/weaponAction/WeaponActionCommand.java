package bluebeer.mhwild.domain.weaponAction;

import bluebeer.mhwild.domain.weaponActionUnit.WeaponActionUnit;
import java.util.List;
import lombok.Data;

@Data
public class WeaponActionCommand {

  String actionId;

  List<WeaponActionUnit> weaponActionUnits;

  String actionName;


}
