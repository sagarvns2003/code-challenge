package vidya.code.chalenge.ubs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoStringHasSameLetters {

  public static boolean match(String str1, String str2) {
    if (ifEqual(str1, str2)) {
      return true;
    }

    char[] arr1 = str1.toCharArray();
    Arrays.sort(arr1);
    char[] arr2 = str2.toCharArray();
    Arrays.sort(arr2);
    str1 = String.valueOf(arr1); //Stream.of(arr1).map(String::valueOf).collect(Collectors.joining());
    str2 = String.valueOf(arr2); //Stream.of(arr2).map(String::valueOf).collect(Collectors.joining());
    return str1.equalsIgnoreCase(str2);
  }

  private static boolean ifEqual(String str1, String str2) {
    return str1.equalsIgnoreCase(str2);
  }

  public static void main(String[] args) {
    log.info("is matching: {}", match("SILENT", "LISTEN"));
    assertTrue(match("SILENT", "LISTEN"));
    assertFalse(match("TEST", "SETS"));
  }
}
