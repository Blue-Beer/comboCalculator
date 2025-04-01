package bluebeer.mhwild.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.Data;

@Data
public class WeaponAction {

  private String weaponId;

  private String actionId;

  private String actionName;

  private String actionUnits;

  private List<WeaponActionUnit> actionUnitList;

  private List<Boolean> actionUnitActiveList;

  private WeaponAction getActiveAction() {

    if (actionUnitList == null || actionUnitActiveList == null
        || actionUnitList.size() != actionUnitActiveList.size()) {
      return null; // 数据不完整，返回 null
    }

    // 过滤掉未激活的 actionUnit
    List<WeaponActionUnit> activeUnits = new ArrayList<>();
    IntStream.range(0, actionUnitList.size())
        .filter(i -> actionUnitActiveList.get(i)) // 只保留 active == true 的
        .forEach(i -> activeUnits.add(actionUnitList.get(i)));

    // 复制当前对象，但只保留激活的 Action Units
    WeaponAction newAction = new WeaponAction();
    newAction.weaponId = this.weaponId;
    newAction.actionId = this.actionId;
    newAction.actionName = this.actionName;
    newAction.actionUnits = this.actionUnits;
    newAction.actionUnitList = activeUnits;

    return newAction;
  }
}
