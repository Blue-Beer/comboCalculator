package bluebeer.mhwild.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

@TableName("WEAPON_ACTION_UNIT")
@Data
public abstract class WeaponActionUnit {

  @TableId
  private String weaponId;
  @TableId
  private String id;
  private String name;
  private BigDecimal actionValue;
  private BigDecimal elementRate;
  private Integer sharpnessConsume;
  private Integer minFrame;
  private Integer maxFrame;
  private Boolean criticalCheck;
  private Boolean hitzoneCheck;

  // 抽象方法，由子类实现
}
