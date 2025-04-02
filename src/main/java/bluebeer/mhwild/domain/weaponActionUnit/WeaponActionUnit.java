package bluebeer.mhwild.domain.weaponActionUnit;

import bluebeer.mhwild.domain.core.Entity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class WeaponActionUnit implements Entity {

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
  private Boolean hitZoneCheck;
}
