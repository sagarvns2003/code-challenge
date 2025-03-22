package vidya.code.chalenge.study;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@Slf4j
public class Demo3 {


  public static void main(String[] args) {

    /*
        String input = "java";
        Map<Character, Long> frequencyMap =    input.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        log.info("{}", frequencyMap);

        //Find the maximum value in a list using Streams
        List<Integer> numbers = List.of(30, 20, 50, 40, 10, 10, 40, 50);
    //    Integer maxNumber = numbers.stream().max((o1,o2) -> o1 - o2).orElse(0);
        //Integer maxNumber = numbers.stream().max(Integer::compareTo).orElse(0);
        Integer maxNumber = numbers.stream().sorted(Comparator.reverseOrder()).limit(1).findFirst().orElse(0);
        //Double avgNumber = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
        Double avgNumber = numbers.stream().mapToInt(n -> (int)n).average().orElse(0);

        List<Integer> duplicateList = numbers.stream().filter(n -> Collections.frequency(numbers, n) > 1).distinct().toList();
       // Set<Integer> duplicateList = numbers.stream()
         //       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
           //     .entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).keySet();

        /*
        Object twoOperation = numbers.stream().collect(Collectors.teeing(
                Collectors.averagingDouble(Integer::intValue),
                Collectors.summingInt(Integer::intValue),
                (avg, sum) -> Map.of("AVG", avg, "SUM", sum)));


        log.info("Max number: {}", maxNumber);
        log.info("Avg number: {}", avgNumber);
        log.info("Duplicate numbers: {}", duplicateList);
        log.info("Two Operation: {}", twoOperation);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ashish", "A", "IT", "Pune", "Software Engineer", 10000d));
        employees.add(new Employee("Amit", "R", "HR", "Pune", "Recruiter", 12000d));
        employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Senior Recruiter", 14000d));
        employees.add(new Employee("Jaya", "S", "IT", "Pune", "Tech Lead", 15000d));
        employees.add(new Employee("Smita", "M", "IT", "Bangalore", "Recruiter", 16000d));
        employees.add(new Employee("Umesh", "A", "IT", "Bangalore", "Software Engineer", 12000d));
        employees.add(new Employee("Pooja", "R", "HR", "Bangalore", "Software Engineer", 12000d));
        employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Recruiter", 16000d));
        employees.add(new Employee("Bobby", "S", "IT", "Bangalore", "Tech Lead", 20000d));
        employees.add(new Employee("Vipul", "M", "IT", "Bangalore", "Software Engineer", 14000d));

        Map<Boolean, List<Employee>> employeeMap = employees.stream().collect(Collectors.partitioningBy(employee -> employee.getDepartment().equalsIgnoreCase("IT")));
        log.info("true: {}", employeeMap.get(true));
        log.info("false: {}", employeeMap.get(false));

        //Optional.of(null);  //Throws null pointer exception
        /*String data = null;
        Optional<String> string =  //Optional.ofNullable("Data"); //Optional.ofNullable(null); //Optional.of(data);
        log.info("{}", string.isEmpty());
        log.info("{}", string.isPresent());
        log.info("{}", string.orElseGet(() -> "NO"));
        log.info("{}", string.orElse("Nothing"));*/

    // duplicate elements in a given integers list in java using Stream functions
    /*  List<Integer> list = List.of(2, 2, 4, 5, 6, 6, 7, 4);
    Map<Integer, Long> map =
        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    List<Integer> flist =
        map.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .map(entry -> entry.getKey())
            .toList();
    log.info("Duplicate list: {}", flist);

    String string = "Java is awesome";
    String firstCh = Arrays.stream(string.split("")).distinct().limit(1).findFirst().get();
    log.info("firstCh: {}", firstCh);*/

    // List<String> list = List.of("mumbai", "pune", "delhi", "mumbai");
    // list.stream().distinct().map(s -> s.length()).sorted(Comparator.reverseOrder()).limit(1);

    //  Map<String, Long> map1 =
    //  list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    // Given a string: aabccdddeeee
    // Write code to compress and transform it as: a2b1c2d3e4
    /*Map<String, Long> map =
            Arrays.stream("aabccdddeeee".split(""))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    String compressedString = map.entrySet().stream().map(entry -> entry.getKey()+entry.getValue()).collect(Collectors.joining());
    System.out.println(compressedString);*/

    /*
    String input = "aabaaabbbcdd";
    String compressed = compressString(input);
    System.out.println(compressed); // Output: a2ba3b3cd2


    IntStream ageStream = IntStream.of(18, 14, 19);
    log.info("Age average: {}", ageStream.average().getAsDouble()); */

    /*String sentence = "My name is Vdy12 Sag$ar Gupta . I am from Varanas1";
    log.info("Count: {}", getCount(sentence));*/


    //  aws s3 ls
    //  aws s3 rm s3://bucketName/ --recursive --exclude "*.png" --exclude "*.jpg" --exclude "*.gif"

/*
    try {
      URL url = new URL("https://www.google.co.in/");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setDoOutput(true);

      Map<String, String> parameters = new HashMap<>();
      parameters.put("param1", "val");

      DataOutputStream out = new DataOutputStream(connection.getOutputStream());
      out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
      out.flush();
      out.close();

      int responseCode = connection.getResponseCode();
      log.info("Response Code: {}", responseCode);

      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuilder content = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      in.close();
      connection.disconnect();

      log.info("Response: {}", content.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }*/
  }

  // aabccaabbbacddb  to a2bc2a2b3acd2b
  public static String compressString(String str) {
    StringBuilder compressed = new StringBuilder();
    int count = 1;

    for (int i = 0; i < str.length(); i++) {
      if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
        count++;
      } else {
        compressed.append(str.charAt(i));
        if (count > 1) {
          compressed.append(count);
        }
        count = 1;
      }
    }

    return compressed.toString();
  }
  public static int getCount(String sentence) {
    Long count =
            Arrays.stream(sentence.split(" "))
                    .filter(Objects::nonNull)
                    .filter(word -> word.length() >= 3)
                    .filter(word -> word.matches("[A-Za-z0-9]+"))
                    .filter(word -> word.matches(".*[aeiouAEIOU].*"))
                    .filter(word -> word.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*"))
                    //.peek(word -> log.info(word))
                    .count();
    return count.intValue();
  }
}

class ParameterStringBuilder {
  public static String getParamsString(Map<String, String> params)
          throws UnsupportedEncodingException {
    StringBuilder result = new StringBuilder();

    for (Map.Entry<String, String> entry : params.entrySet()) {
      result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
      result.append("=");
      result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
      result.append("&");
    }

    String resultString = result.toString();
    return resultString.length() > 0
            ? resultString.substring(0, resultString.length() - 1)
            : resultString;
  }
}
