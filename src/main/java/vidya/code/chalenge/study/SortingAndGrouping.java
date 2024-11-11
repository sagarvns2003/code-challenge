package vidya.code.chalenge.study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingAndGrouping {

  public static void main(String[] args) {

    List<Product> products =
        List.of(
            new Product("Laptop", 1000),
            new Product("Shirt", 20),
            new Product("TShirt", 20),
            new Product("Phone", 500));

    // Sorting with two fields
    List<Product> sortedByPriceAndItemAsc =
        products.stream()
            .sorted(Comparator.comparingInt(Product::getPrice).thenComparing(Product::getItem))
            .toList();
    System.out.println(sortedByPriceAndItemAsc);

    List<Product> sortedByPriceAndItemDesc =
        products.stream()
            .sorted(
                Comparator.comparingInt(Product::getPrice)
                    .thenComparing(Product::getItem)
                    .reversed())
            .toList();
    System.out.println(sortedByPriceAndItemDesc);

    List<Product> sortedByPriceAsc =
        products.stream()
            .sorted(Comparator.comparingInt(Product::getPrice)) // Sorts in ascending order by price
            .collect(Collectors.toList());
    System.out.println(sortedByPriceAsc);

    List<Product> sortedByPriceDesc =
        products.stream()
            .sorted(Comparator.comparingInt(Product::getPrice).reversed())
            .collect(Collectors.toList());
    System.out.println(sortedByPriceDesc);

    List<Product> sortedByItemName =
        products.stream()
            .sorted(Comparator.comparing(Product::getItem).reversed())
            .collect(Collectors.toList());
    System.out.println(sortedByItemName);

    Map<String, List<Product>> productsByItem =
        products.stream().collect(Collectors.groupingBy(Product::getItem));
    System.out.println(productsByItem);

    Map<Integer, List<Product>> productsByPrice =
        products.stream().collect(Collectors.groupingBy(Product::getPrice));
    System.out.println(productsByPrice);

    int[] arr = {0, 8, 2, 0, 0, 5};
    Arrays.stream(arr).boxed().forEach(System.out::print);
  }
}
