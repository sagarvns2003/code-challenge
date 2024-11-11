package vidya.code.chalenge.study;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseStringWordWise {
  private static String reverseStringWordWise(String input) {
    List<String> words = Arrays.asList(input.split(" "));
    String a = "";
    for (int i = words.size() - 1; i >= 0; i--) {
      a = a + words.get(i) + " ";
    }
    return a;
  }

  public static void main(String[] args) {
    System.out.print("Please enter some words: ");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    String ans = reverseStringWordWise(input);
    System.out.println(ans);
  }
}
