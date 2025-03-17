package bluebeer.mhwild.adapter.driven;

import bluebeer.mhwild.domain.WeaponActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WeaponActionRepositoryImpl implements WeaponActionRepository {

  private final WeaponActionMapper weaponActionMapper;
}
