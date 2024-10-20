package vidya.code.chalenge.hsbc;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxTwoSum {

  public static void main(String[] args) {
    List<Integer> list = List.of(12, 4, 50, 8);
    log.info("Sum of max two: {}", getMaxTwoSum(list));
  }

  private static int getMaxTwoSum(List<Integer> list) {
    if (Objects.isNull(list) || list.isEmpty()) {
      return 0;
    }
    return list.stream().sorted(Comparator.reverseOrder()).limit(2).reduce(0, Integer::sum);
  }
}
