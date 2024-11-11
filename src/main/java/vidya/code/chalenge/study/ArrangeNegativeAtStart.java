package vidya.code.chalenge.study;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrangeNegativeAtStart {

  static void arrange(int[] arr) {
    int j = 0, temp;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        if (i != j) {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
        j++;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
    arrange(arr);
    log.info("After re-arrange: {}", Arrays.toString(arr));
  }
}
