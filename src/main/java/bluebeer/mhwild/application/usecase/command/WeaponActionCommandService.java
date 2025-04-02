package bluebeer.mhwild.application.usecase.command;

import bluebeer.mhwild.adapter.driven.database.weaponAction.WeaponActionMapper;
import bluebeer.mhwild.domain.weaponAction.WeaponAction;
import bluebeer.mhwild.domain.weaponAction.WeaponActionCommand;
import bluebeer.mhwild.domain.weaponAction.WeaponActionFactory;
import bluebeer.mhwild.domain.weaponAction.WeaponActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeaponActionCommandService {

  private final WeaponActionMapper weaponActionMapper;

  private final WeaponActionFactory weaponActionFactory;

  private final WeaponActionRepository weaponActionRepository;

  public String save(String weaponId, WeaponActionCommand command) {

    WeaponAction newAction = weaponActionFactory.create(weaponId, command);

    weaponActionRepository.save(newAction);

    return newAction.getActionId();

  }

}
