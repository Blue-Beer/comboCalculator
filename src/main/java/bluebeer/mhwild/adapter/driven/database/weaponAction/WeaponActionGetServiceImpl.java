package bluebeer.mhwild.adapter.driven.database.weaponAction;

import bluebeer.mhwild.adapter.driven.database.weaponActionUnit.WeaponActionUnitMapper;
import bluebeer.mhwild.adapter.driven.database.weaponActionUnit.WeaponActionUnitPo;
import bluebeer.mhwild.application.model.WeaponActionDto;
import bluebeer.mhwild.application.usecase.query.WeaponActionGetService;
import bluebeer.mhwild.domain.weaponActionUnit.WeaponActionUnit;
import bluebeer.mhwild.tool.BeanCopyUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeaponActionGetServiceImpl implements WeaponActionGetService {

  private final WeaponActionMapper weaponActionMapper;
  private final WeaponActionUnitMapper weaponActionUnitMapper;


  @Override
  public WeaponActionPo getWeaponAction(String weaponId, String actionId) {
    LambdaQueryWrapper<WeaponActionPo> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(WeaponActionPo::getWeaponId, weaponId);
    queryWrapper.eq(WeaponActionPo::getActionId, actionId);

    return weaponActionMapper.selectOne(queryWrapper);
  }

  @Override
  public List<WeaponActionPo> getWeaponActions(String weaponId) {

    LambdaQueryWrapper<WeaponActionPo> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(WeaponActionPo::getWeaponId, weaponId);
    queryWrapper.orderByAsc(WeaponActionPo::getActionId);

    return weaponActionMapper.selectList(queryWrapper);
  }

  @Override
  public WeaponActionDto getUnits(WeaponActionPo weaponAction) {

    WeaponActionDto weaponActionDto = new WeaponActionDto();
    BeanCopyUtil.copyProperties(weaponAction, weaponActionDto);
    List<String> units = Arrays.asList(weaponActionDto.getActionUnits().split(","));
    List<WeaponActionUnit> actionUnitList = new ArrayList<>();
    List<Boolean> actionUnitActiveList = new ArrayList<>();
    for (String unit : units) {
      actionUnitActiveList.add(true);

      LambdaQueryWrapper<WeaponActionUnitPo> queryWrapper = new LambdaQueryWrapper<>();
      queryWrapper.eq(WeaponActionUnitPo::getId, unit);
      queryWrapper.eq(WeaponActionUnitPo::getWeaponId, weaponAction.getWeaponId());
      WeaponActionUnitPo weaponActionUnit = weaponActionUnitMapper.selectOne(queryWrapper);

      WeaponActionUnit actionUnit = new WeaponActionUnit();
      BeanCopyUtil.copyProperties(weaponActionUnit, actionUnit);

      actionUnitList.add(actionUnit);
    }
    weaponActionDto.setActionUnitList(actionUnitList);
    weaponActionDto.setActionUnitActiveList(actionUnitActiveList);

    return weaponActionDto;
  }


}
