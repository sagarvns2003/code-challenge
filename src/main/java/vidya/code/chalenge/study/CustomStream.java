package vidya.code.chalenge.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import lombok.extern.slf4j.Slf4j;

interface MyStream<T> {
  <R> MyStream<R> map(Function<? super T, ? extends R> mapper);

  MyStream<T> filter(Predicate<? super T> predicate);

  void forEach(Consumer<? super T> consumer);
}

class MyStreamImpl<T> implements MyStream<T> {

  private final List<T> source;

  public MyStreamImpl(List<T> list) {
    this.source = list;
  }

  @Override
  public <R> MyStream<R> map(Function<? super T, ? extends R> mapper) {
    List<R> result = new ArrayList<>();
    for (T item : source) {
      result.add(mapper.apply(item));
    }
    return new MyStreamImpl<>(result);
  }

  @Override
  public MyStream<T> filter(Predicate<? super T> predicate) {
    List<T> result = new ArrayList<>();
    for (T item : source) {
      if (predicate.test(item)) {
        result.add(item);
      }
    }
    return new MyStreamImpl<>(result);
  }

  @Override
  public void forEach(Consumer<? super T> consumer) {
    for (T item : source) {
      consumer.accept(item);
    }
  }
}

@Slf4j
public class CustomStream {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    MyStream<Integer> customStream = new MyStreamImpl<>(numbers);
    customStream.filter(n -> n % 2 == 0).map(n -> n * n).forEach(n -> log.info("{}", n));
  }
}
