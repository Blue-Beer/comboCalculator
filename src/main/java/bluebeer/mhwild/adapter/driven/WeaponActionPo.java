package bluebeer.mhwild.adapter.driven;

import bluebeer.mhwild.domain.WeaponActionUnit;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.Data;

@TableName("WEAPON_ACTION")
@Data
public class WeaponActionPo {

  private String weaponId;
  @TableId
  private String actionId;

  private String actionName;

  private String actionUnits;

//  private WeaponActionPo getActiveAction() {
//
//    if (actionUnitList == null || actionUnitActiveList == null
//        || actionUnitList.size() != actionUnitActiveList.size()) {
//      return null; // 数据不完整，返回 null
//    }
//
//    // 过滤掉未激活的 actionUnit
//    List<WeaponActionUnit> activeUnits = new ArrayList<>();
//    IntStream.range(0, actionUnitList.size())
//        .filter(i -> actionUnitActiveList.get(i)) // 只保留 active == true 的
//        .forEach(i -> activeUnits.add(actionUnitList.get(i)));
//
//    // 创建新对象，保留已激活的 Action Units
//    WeaponActionPo newAction = new WeaponActionPo();
//    newAction.setWeaponId(this.weaponId);
//    newAction.setActionId(this.actionId);
//    newAction.setActionName(this.actionName);
//    newAction.setActionUnits(this.actionUnits);
//    newAction.setActionUnitList(activeUnits);
//    newAction.setActionUnitActiveList(null); // 这个可以不再需要
//
//    return newAction;
//  }
}
