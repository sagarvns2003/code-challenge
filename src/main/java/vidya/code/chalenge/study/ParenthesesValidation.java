package vidya.code.chalenge.study;

import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

/*

Input: s = "[()]{}{[()()]()}"
Output: true
Explanation: All the brackets are well-formed

Input: s = "[(])"
Output: false
Explanation: 1 and 4 brackets are not balanced because
there is a closing ‘]’ before the closing ‘(‘

 */
@Slf4j
public class ParenthesesValidation {

  public static boolean validateParentheses(String parentheses) {

    // If length is odd
    if (parentheses.length() % 2 != 0) {
      return false;
    }

    Stack<Character> characterStack = new Stack<>();
    for (int i = 0; i < parentheses.length(); i++) {
      // Check if opening char
      if (parentheses.charAt(i) == '('
          || parentheses.charAt(i) == '['
          || parentheses.charAt(i) == '{') {
        characterStack.push(parentheses.charAt(i));
      } else {
        Character ch = characterStack.peek();
        if (ch == '(' && parentheses.charAt(i) == ')'
            || ch == '[' && parentheses.charAt(i) == ']'
            || ch == '{' && parentheses.charAt(i) == '}') {
          characterStack.pop();
        } else {
          return false;
        }
      }
    }

    // if empty that mean balanced
    return characterStack.isEmpty();
  }

  public static void main(String[] args) {
    log.info("Valid Parentheses: {}", validateParentheses("[(]))"));
    log.info("Valid Parentheses: {}", validateParentheses("[()]{}{[()()]()}"));
    log.info("Valid Parentheses: {}", validateParentheses("[(])]]]"));
  }
}
