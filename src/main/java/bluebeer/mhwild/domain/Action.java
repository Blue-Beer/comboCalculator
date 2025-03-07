package bluebeer.mhwild.domain;


import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Data
@SuperBuilder
@RequiredArgsConstructor
@Entity
public class Action {
  private final String weaponId;

  private final String id;
  private final String name;

  private final int action;

  private final double elementRate;

//  private List<String> comboOptionIds;
}
