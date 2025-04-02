package bluebeer.mhwild.adapter.driven.database.weaponAction;

import bluebeer.mhwild.domain.weaponAction.WeaponAction;
import bluebeer.mhwild.domain.weaponAction.WeaponActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WeaponActionRepositoryImpl implements WeaponActionRepository {

  private final WeaponActionMapper weaponActionMapper;

  @Override
  public void save(WeaponAction newAction) {
    WeaponActionPo po = WeaponActionPo.toPo(newAction);
    weaponActionMapper.deleteById(po.getActionId());

    weaponActionMapper.insert(po);
  }
}
