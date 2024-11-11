package vidya.code.chalenge.study;

import java.util.*;

/**
 * Provide cost... Given an array, reduce the array to a single element with minimum cost. For
 * reducing, remove two elements from the array, add those two numbers and keep the sum back in the
 * array. The cost of each operation is the sum of the elements removed in that step.
 *
 * <p>Example, let the array A = [1,2,3]
 *
 * <p>Then, we can remove 1 and 2, add both of them and keep the sum back in array. Cost of this
 * step would be (1+2) = 3.
 *
 * <p>So A = [3,3], Cost = 3
 *
 * <p>In second step, we can remove both elements from the array and keep the sum back in array
 * again. Cost of this step would be 3 + 3 = 6.
 *
 * <p>So, A = [6], Cost = 6
 *
 * <p>So total cost turns out to be 9 (6+3).
 */
public class ReduceArray {
  public static int sumAndCost(List<Integer> arr) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr);
    int cost = 0;
    int sum = priorityQueue.poll();
    while (!priorityQueue.isEmpty()) {
      int currentElement = priorityQueue.poll();
      if (currentElement < sum) {
        priorityQueue.add(sum);
        sum = currentElement;
      } else {
        sum += currentElement;
        cost += sum;
        continue;
      }
      sum += priorityQueue.poll();
      cost += sum;
    }
    return cost;
  }

  public static void main(String[] args) {
    List<Integer> arr = List.of(1, 2, 3);
    int cost = sumAndCost(arr);
    System.out.println("Cost of reduced array: " + cost);
  }
}
