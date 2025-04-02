package bluebeer.mhwild.adapter.driving;

import bluebeer.mhwild.application.model.WeaponActionDto;
import bluebeer.mhwild.application.usecase.query.WeaponActionQueryService;
import bluebeer.mhwild.tool.R;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weapon/{weaponId}/action/{actionId}")
@RequiredArgsConstructor
public class WeaponActionResource {

  private final WeaponActionQueryService queryService;

  @GetMapping
  public ResponseEntity<R<WeaponActionDto>> get(
      @PathVariable String weaponId,
      @PathVariable String actionId
  ) {
    return ResponseEntity.ok(R.ok(queryService.getWeaponAction(weaponId, actionId)));
  }

}
