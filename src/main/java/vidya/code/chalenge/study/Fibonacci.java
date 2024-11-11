package vidya.code.chalenge.study;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fibonacci {

  public static List<Integer> generateFibonacci(int n) {
    // Using stream api...
    return Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
        .limit(n)
        .map(t -> t[0])
        .toList();
  }

  public static void main(String[] args) {
    List<Integer> list = generateFibonacci(10);
    log.info("Fibonacci... {}", list);
    assertEquals(10, list.size());
  }
}
