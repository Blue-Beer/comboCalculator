package bluebeer.mhwild.adapter.driving;

import bluebeer.mhwild.application.usecase.aggregate.ActionsComboAnalysisDto;
import bluebeer.mhwild.application.usecase.aggregate.ActionsComboAnalysisService;
import bluebeer.mhwild.application.usecase.aggregate.ActionsComboQuery;
import bluebeer.mhwild.tool.R;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combo")
@RequiredArgsConstructor
public class ActionsComboResource {

  private final ActionsComboAnalysisService actionsComboAnalysisService;

  /**
   * 分析一个给定组合的各项数据
   */
  @PostMapping
  public ResponseEntity<R<ActionsComboAnalysisDto>> singleAnalysis(
      @RequestBody ActionsComboQuery query
  ) {
    ActionsComboAnalysisDto result = actionsComboAnalysisService.singleAnalysis(query);
    return ResponseEntity.ok(R.ok(result));
  }
}
