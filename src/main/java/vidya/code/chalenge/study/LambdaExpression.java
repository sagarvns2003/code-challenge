package vidya.code.chalenge.study;

import lombok.extern.slf4j.Slf4j;

@FunctionalInterface
interface AddOperation {
  int handle(int a, int b);
}

@Slf4j
public class LambdaExpression {

  public static void main(String[] args) {

    AddOperation add = (a, b) -> a + b;
    log.info("Addition: {}", add.handle(10, 30));

  }
}
