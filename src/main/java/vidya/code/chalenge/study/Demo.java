package vidya.code.chalenge.study;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  public static List<List<String>> getProductSuggestions1(List<String> products, String search) {
    List<List<String>> suggestions = new ArrayList<>();
    for (int i = 0; i < search.length(); i++) {
      String searchStr = search.substring(0, i + 1);
      List<String> searchedList =
          products.stream().filter(p -> p.startsWith(searchStr)).sorted().limit(3).toList();
      suggestions.add(searchedList);
    }
    return suggestions;
  }

  public static int add(int i, int j) {
    return i + j;
  }

  public static List<List<String>> getProductSuggestions2(List<String> products, String search) {
    // Sort the products list lexicographically
    Collections.sort(products);

    List<List<String>> suggestions = new ArrayList<>();
    String prefix = "";

    for (char c : search.toCharArray()) {
      prefix += c;
      List<String> matches = new ArrayList<>();

      // Use binary search to quickly find the starting point of the prefix
      int start = Collections.binarySearch(products, prefix);

      // If exact match isn't found, binarySearch returns a negative value
      // The negative value gives the insertion point where the prefix would be
      if (start < 0) {
        start = -start - 1;
      }

      // Collect up to three lexicographically the smallest matches
      for (int i = start; i < products.size() && matches.size() < 3; i++) {
        if (products.get(i).startsWith(prefix)) {
          matches.add(products.get(i));
        } else {
          break; // Since the list is sorted, no need to check further if the prefix doesn't match
        }
      }

      suggestions.add(matches);
    }

    return suggestions;
  }

  public int solution(String binaryString) {
    // Convert big binary number to big int number
    BigInteger number = new BigInteger(binaryString, 2);
    int operationCount = 0;
    while (number.compareTo(BigInteger.ZERO) > 0) {
      if (number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
        number = number.divide(BigInteger.TWO);
      } else {
        number = number.subtract(BigInteger.ONE);
      }
      operationCount++;
    }
    // Now return to count
    return operationCount;
  }

  public static void main(String[] args) {

    List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
    List withoutBlanks = sampleList.stream()
            .filter(Predicate.not(String::isBlank))
            .collect(Collectors.toList());
    System.out.println(withoutBlanks);

    System.out.println(String.format("id = %08.2f", 423.147));

    short s = 9;
    add(s, 6);

    // Given a string: aabccdddeeee
    // Write code to compress and transform it as: a2b1c2d3e4
    Map<String, Long> map =
        Arrays.stream("aabccdddeeee".split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    String compressedString = map.entrySet().stream().map(entry -> entry.getKey()+entry.getValue()).collect(Collectors.joining());
    System.out.println(compressedString);


    Map<String, String> hashMap = new HashMap<>();
    hashMap.put(null, "hello");
    hashMap.put(null, "hi");
    hashMap.put("key1", null);
    hashMap.put("key2", null);
    System.out.println("hashMap: " + hashMap);

    Map<String, String> hashTable = new Hashtable<>();
    hashTable.put("key1", "Hi");
    hashTable.put("key2", "null");
    hashTable.put("key1", "Hello");
    System.out.println("hashTable: " + hashTable);

    List<String> list = "ABC, XYZ, LMN".transform(str -> Arrays.stream(str.split(",")).toList());
    System.out.println("List: " + list);

    // Sorting characters alphabetically in a String
    String sortedString = Stream.of("hello".split("")).sorted().collect(Collectors.joining());
    System.out.println("sortedString: " + sortedString);

    Number[] a = new Double[2];
    // a[0] = 4;  //ArrayStoreException will be thrown due to wrong type storing
    a[0] = 4d;

    /*Vector a1 = new Vector(21312312);
    Vector a2 = new Vector(2147412344);
    Vector a3 = new Vector(219944);
    System.out.println("Memory Leak in Java");*/

    List<String> products = new ArrayList<>();
    products.add("carpet");
    products.add("cart");
    products.add("car");
    products.add("camera");
    products.add("crate");

    List<List<String>> searched = getProductSuggestions1(products, "camera");
    System.out.println(searched);
    searched = getProductSuggestions2(products, "camera");
    System.out.println(searched);

    int sum =
        Stream.iterate(new int[] {0, 1}, x -> new int[] {x[1], x[0] + x[1]})
            .limit(8)
            .map(x -> x[0])
            .collect(Collectors.toList())
            .stream()
            .distinct()
            .filter(i -> i % 2 == 0)
            .mapToInt(i -> i)
            .sum();
    System.out.println("Sum: " + sum);

    Stream.generate(new Random()::nextInt).limit(10).toList().forEach(System.out::println);
    Stream.iterate("abc", i -> i.toUpperCase()).limit(5).toList().forEach(System.out::println);

    List<Product> products1 =
        List.of(
            new Product("Laptop", 100.0),
            new Product("Shirt", 2.0),
            new Product("TShirt", 2.0),
            new Product("Phone", -50.0));

    /*List<Product> sortedByPriceAndItemAsc =
    products.stream()
            .sorted(Comparator.comparing(Product::getPrice).thenComparing(Product::getItem))
            .toList();*/

    products1.stream() // .map(Product::getPrice)
        .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
        .forEach(System.out::println);

    /*  List<Product> sortedByPriceAsc =
            products.parallelStream().skip(2)
                .sorted(Comparator.comparingInt(Product::getPrice)) // Sorts in ascending order by price
                .collect(Collectors.toList());

        List<Product> sortedByPriceDesc =
            products.stream()
                .sorted(Comparator.comparingInt(Product::getPrice).reversed())
                .collect(Collectors.toList());

        List<Product> sortedByItemName =
            products.stream()
                .sorted(Comparator.comparing(Product::getItem).reversed())
                .collect(Collectors.toList());

        Map<String, List<Product>> productsByItem =
            products.stream().collect(Collectors.groupingBy(Product::getItem));

        Map<Integer, List<Product>> productsByPrice =
            products.stream().collect(Collectors.groupingBy(Product::getPrice));
    */
    /*  System.out.println(sortedByPriceAndItemAsc);
    System.out.println(sortedByPriceAsc);
    System.out.println(sortedByPriceDesc);
    System.out.println(sortedByItemName);
    System.out.println(productsByItem);
    System.out.println(productsByPrice);

    int[] arr = {0, 8, 2, 0, 0, 5};
    Arrays.stream(arr).boxed().forEach(System.out::print);*/
  }
}
