package vidya.code.chalenge.ibm;

import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/*
 * This program is to checks if a given string contains every letter of the English alphabet.
 * e.g. "The quick brown fox jumps over the lazy dog" is pangram string.
 */
@Slf4j
public class Pangram {

  public static boolean isPangram(String str) {
    if (str == null) {
      return false;
    }
    Set<Character> letters = new HashSet<>();
    for (char c : str.toLowerCase().toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        letters.add(c);
      }
    }
    return letters.size() == 26;
  }

  public static void main(String[] args) {
    String testStr = "The quick brown fox jumps over the lazy dog";
    if (isPangram(testStr)) {
      log.info("The string is a pangram.");
    } else {
      log.info("The string is not a pangram.");
    }
  }
}
