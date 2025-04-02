package bluebeer.mhwild.adapter.driving;

import bluebeer.mhwild.application.model.WeaponActionDto;
import bluebeer.mhwild.application.usecase.command.WeaponActionCommandService;
import bluebeer.mhwild.application.usecase.query.WeaponActionQueryService;
import bluebeer.mhwild.domain.weaponAction.WeaponActionCommand;
import bluebeer.mhwild.tool.R;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weapon/{weaponId}/actions")
@RequiredArgsConstructor
public class WeaponActionsResource {

  private final WeaponActionQueryService queryService;
  private final WeaponActionCommandService commandService;

  @GetMapping
  public ResponseEntity<R<List<WeaponActionDto>>> getWeaponActions(
      @PathVariable String weaponId
  ) {

    List<WeaponActionDto> weaponActions = queryService.getWeaponActions(weaponId);

    return ResponseEntity.ok(R.ok(weaponActions));
  }

  @PostMapping
  public ResponseEntity<R<String>> saveWeaponActions(
      @PathVariable String weaponId,
      @RequestBody WeaponActionCommand command
  ) {

    String actionId = commandService.save(weaponId, command);

    return ResponseEntity.ok(R.ok(actionId, "保存成功"));
  }


}
