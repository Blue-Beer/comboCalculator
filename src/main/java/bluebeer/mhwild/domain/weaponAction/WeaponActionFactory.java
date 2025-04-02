package bluebeer.mhwild.domain.weaponAction;

import bluebeer.mhwild.domain.weaponActionUnit.WeaponActionUnit;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class WeaponActionFactory {

  public WeaponAction create(String weaponId, WeaponActionCommand command){

    String actionId = StringUtils.hasText(command.getActionId())
        ? command.getActionId() : IdWorker.getIdStr();

    WeaponAction newAction = new WeaponAction();

    String actionName = command.getActionName();
    List<WeaponActionUnit> weaponActionUnits = command.getWeaponActionUnits();

    newAction.setActionId(actionId);
    newAction.setWeaponId(weaponId);
    newAction.setActionName(actionName);
    String actionUnits = weaponActionUnits.stream()
        .map(WeaponActionUnit::getId)
        .reduce((a, b) -> a + "," + b)
        .orElse("");
    newAction.setActionUnits(actionUnits);
    newAction.setActionUnitList(weaponActionUnits);

    return newAction;
  }

}