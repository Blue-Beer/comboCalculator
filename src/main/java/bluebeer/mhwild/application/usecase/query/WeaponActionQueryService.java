package bluebeer.mhwild.application.usecase.query;

import bluebeer.mhwild.application.model.WeaponActionDto;
import bluebeer.mhwild.domain.WeaponAction;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeaponActionQueryService {

  private final WeaponActionGetService weaponActionGetService;

  public List<WeaponActionDto> getWeaponActions(String weaponId) {

    return null;
  }
}
