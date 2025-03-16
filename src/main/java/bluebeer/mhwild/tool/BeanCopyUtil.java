package bluebeer.mhwild.tool;

import java.lang.reflect.Field;

public class BeanCopyUtil {

  /**
   * 复制源对象到目标对象，仅复制同名同类型的字段
   *
   * @param source 源对象
   * @param target 目标对象
   */
  public static void copyProperties(Object source, Object target) {
    if (source == null || target == null) {
      throw new IllegalArgumentException("源对象和目标对象不能为空");
    }

    Class<?> sourceClass = source.getClass();
    Class<?> targetClass = target.getClass();

    Field[] sourceFields = sourceClass.getDeclaredFields();

    for (Field sourceField : sourceFields) {
      try {
        // 只处理非静态字段
        if (java.lang.reflect.Modifier.isStatic(sourceField.getModifiers())) {
          continue;
        }

        String fieldName = sourceField.getName();
        Field targetField;

        try {
          targetField = targetClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
          continue; // 目标对象没有该字段，跳过
        }

        // 确保字段类型匹配
        if (!targetField.getType().equals(sourceField.getType())) {
          continue;
        }

        // 允许访问私有字段
        sourceField.setAccessible(true);
        targetField.setAccessible(true);

        // 复制字段值
        targetField.set(target, sourceField.get(source));

      } catch (IllegalAccessException ignored) {
        // 忽略无法访问的字段
      }
    }
  }
}