package bluebeer.mhwild.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, String> {
  // 你可以根据需要添加自定义查询方法
  List<Action> findByName(String name);  // 按名称查询
}