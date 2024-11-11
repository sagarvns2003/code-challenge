package vidya.code.chalenge.study;

/**
 * Remove the substring AB & BB from a given string seq repeatedly and print the number of remaining
 * characters in the seq string
 */
public class RemoveSubstringRepeatedly {
  public static int removeSubstring(String seq) {
    String toRemoveAB = "AB";
    String toRemoveBB = "BB";
    while (seq.contains(toRemoveAB) || seq.contains(toRemoveBB)) {
      if (seq.contains(toRemoveAB)) {
        seq = remove(seq, toRemoveAB);
      } else if (seq.contains(toRemoveBB)) {
        seq = remove(seq, toRemoveBB);
      }
    }
    return seq.length();

    /*while (true) {
      if (seq.contains(toRemoveAB)) {
        seq = remove(seq, toRemoveAB);
      } else if (seq.contains(toRemoveBB)) {
        seq = remove(seq, toRemoveBB);
      } else {
        break;
      }
    }
    return seq.length();
    */
  }

  private static String remove(String seq, String toBeRemove) {
    return seq.replace(toBeRemove, "");
  }

  public static void main(String[] args) {
    String input = "AABBC";
    int remainingCount = removeSubstring(input);
    System.out.println(
        "Remaining String Count after removing substrings repeatedly: " + remainingCount);
  }
}
