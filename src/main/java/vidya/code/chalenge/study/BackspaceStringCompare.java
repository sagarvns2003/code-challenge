package vidya.code.chalenge.study;

/*
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. 
 * hash '#' means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * Example:
       Input: s = "ab#c", t = "ad#c"
       Output: true
       Explanation: Both s and t become "ac".
 *
 */
public class BackspaceStringCompare {

	public static void main(String[] args) {

		//input strings
		String s = "#ab#c", t = "ad#c";

		System.out.println("Is both strings are same ? " + compare(s, t));
	}

	private static boolean compare(String s, String t) {
		s = prepareString(s);
		t = prepareString(t);

		System.out.println("Final string: " + s);
		System.out.println("Final string: " + t);

		return s.equals(t);
	}

	private static String prepareString(String string) {
		StringBuilder sb = new StringBuilder();
		for (char ch : string.toCharArray()) {
			if (ch == '#' && sb.length() != 0) {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				if (ch != '#') {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
}
