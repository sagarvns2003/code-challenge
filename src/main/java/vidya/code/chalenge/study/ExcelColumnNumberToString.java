package vidya.code.chalenge.study;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelColumnNumberToString {

  public static String getColumnString(int columnNumber) {
    StringBuilder result = new StringBuilder();
    while (columnNumber > 0) {
      columnNumber--; // Adjust to 0-based index
      char currentChar = (char) ('A' + columnNumber % 26);
      result.insert(0, currentChar);
      columnNumber /= 26;
    }
    return result.toString();
  }

  public static void main(String[] args) {
    int columnNumber = 52; // Example column number
    String columnString = getColumnString(columnNumber);
    log.info("Column string for column number {}: {}", columnNumber, columnString);
  }
}
