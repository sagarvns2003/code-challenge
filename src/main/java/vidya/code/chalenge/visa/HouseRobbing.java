package vidya.code.chalenge.visa;

// Example 1:
// Input: Houses = [1,0,0,0,1], n = 1
// Output: true

// Example 2:
// Input: Houses = [1,0,0,0,1], n = 2
// Output: false
// Example 3:
// Input: Houses = [1,0,0,0,0,1], n = 2
// Output: false
// Example 4:
// Input: Houses = [1,0,0,0,0,0,1], n = 2
// Output: true
// Example 5:
// Input: Houses = [1,0,1,0,1], n = 1
// Output : false
// Example 6:
// Input: Houses = [0,0,1,0,1,0,0] , n = 1
// Output: true
// Example 7
// Input houses = [1], n = 0
// output: true
// Example 8
// Input houses = [0], n = 1
// output: true
public class HouseRobbing {
  public static void main(String[] args) {

    int[] houses = {1,0,0,0,0,0,1};
    int n = 2;

    System.out.println("Can rob houses: " + canRobHouses(houses, n));
  }

  public static boolean canRobHouses(int[] houses, int n) {
    int numOfHouseToBeRobbed = 0;
    boolean prevHouseBeingRobbed = false;
    for (int i = 0; i < houses.length; i++) {
      int house = houses[i];

      if (houses.length == 1 && canRob(house) && (n == 1 || n == 0)) {
        return true;
      } else if (houses.length == 1 && (n == 0) && !canRob(house)) {
        return true;
      }

      if (canRob(house) && i >= 0 && i <= houses.length) {
        if (i == 0) {
          int nextHouse = houses[i + 1];
          if (canRob(nextHouse) && !prevHouseBeingRobbed) {
            numOfHouseToBeRobbed += 1;
            prevHouseBeingRobbed = true;
          } else {
            prevHouseBeingRobbed = false;
          }
        } else if (i == houses.length - 1) {
          int prevHouse = houses[i - 1];
          if (canRob(prevHouse) && !prevHouseBeingRobbed) {
            numOfHouseToBeRobbed += 1;
            prevHouseBeingRobbed = true;
          } else {
            prevHouseBeingRobbed = false;
          }
        } else {
          int prevHouse = houses[i - 1];
          int nextHouse = houses[i + 1];
          if (canRob(prevHouse) && canRob(nextHouse) && !prevHouseBeingRobbed) {
            numOfHouseToBeRobbed += 1;
            prevHouseBeingRobbed = true;
          } else {
            prevHouseBeingRobbed = false;
          }
        }
      }
    }
    return (n <= numOfHouseToBeRobbed);
  }

  private static boolean canRob(int house) {
    return 1 == house ? false : true;
  }
}
