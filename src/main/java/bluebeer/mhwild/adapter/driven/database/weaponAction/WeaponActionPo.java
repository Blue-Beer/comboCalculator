package bluebeer.mhwild.adapter.driven.database.weaponAction;

import bluebeer.mhwild.domain.weaponAction.WeaponAction;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("WEAPON_ACTION")
@Data
public class WeaponActionPo {


  @TableId
  private String actionId;

  private String weaponId;

  private String actionName;

  private String actionUnits;

  public static WeaponActionPo toPo(WeaponAction weaponAction) {
    WeaponActionPo po = new WeaponActionPo();
    po.setActionId(weaponAction.getActionId());
    po.setWeaponId(weaponAction.getWeaponId());
    po.setActionName(weaponAction.getActionName());
    po.setActionUnits(weaponAction.getActionUnits());
    return po;
  }
}
