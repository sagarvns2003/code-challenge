package vidya.code.chalenge.study;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Factorial {

  public static Integer factorial(int n) {
    if (n <= 1) return n;
    return (n * factorial(n - 1));
  }

  public static void main(String[] args) {
    log.info("Factorial of 5: {}", factorial(5));
    assertEquals(120, factorial(5));
    assertEquals(6, factorial(3));
  }
}
