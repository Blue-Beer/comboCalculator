package bluebeer.mhwild.application.model;

import bluebeer.mhwild.domain.weaponActionUnit.WeaponActionUnit;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class WeaponActionDto {

  private String weaponId;

  private String actionId;

  private String actionName;

  private String actionUnits;

  private List<WeaponActionUnit> actionUnitList;

  private List<Boolean> actionUnitActiveList;

}
