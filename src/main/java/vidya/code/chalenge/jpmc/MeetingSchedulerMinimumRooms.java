package vidya.code.chalenge.jpmc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Find the minimum number of meeting rooms required for the given meeting time intervals in a 2D
 * array (start time and end time)
 *
 * <p>Example.. 2D array of meeting intervals start and end time are { { 1, 20 }, { 19, 30}, { 40,
 * 70 } }.
 *
 * <p>Let's assign a room to each interval. Assign room 1 to first interval (1, 20). The second
 * interval start when the first interval is going on, so assign room 2 to the second interval (19,
 * 30). The third interval starts after the second interval. Therefore, assign room 2 to the third
 * interval (40, 70). Hence, we required total 2 rooms for meeting.
 */
public class MeetingSchedulerMinimumRooms {
  public static int getMinimumRooms(List<List<Integer>> intervals) {

    if (Objects.isNull(intervals) || intervals.isEmpty()) {
      return 0;
    }

    List<Integer> start = intervals.stream().map(interval -> interval.get(0)).sorted().toList();
    List<Integer> end = intervals.stream().map(interval -> interval.get(1)).sorted().toList();

    int i = 1, j = 0, curr = 1;
    int minimumRooms = 1;

    // executes when any both conditions return true
    while (i < start.size() && j < end.size()) {
      // j-th meeting is going on
      if (start.get(i) < end.get(j)) {
        // incrementing the meeting room
        curr++;
        // incrementing I because i-th meeting has started
        i++;
      } else {
        // decrements the meeting room by 1 because meeting room is free
        curr--;
        // increments the j-th meeting
        j++;
      }
      // find the max of minimumRooms and curr
      minimumRooms = Integer.max(minimumRooms, curr);
    }
    return minimumRooms;
  }

  public static void main(String args[]) {
    List<List<Integer>> intervalList = new ArrayList<List<Integer>>();
    intervalList.add(Arrays.asList(1, 20));
    intervalList.add(Arrays.asList(19, 30));
    intervalList.add(Arrays.asList(40, 70));

    /*intervalList.add(Arrays.asList(1, 18));
    intervalList.add(Arrays.asList(18, 23));
    intervalList.add(Arrays.asList(15, 29));
    intervalList.add(Arrays.asList(4, 15));
    intervalList.add(Arrays.asList(2, 11));
    intervalList.add(Arrays.asList(5, 13));*/

    int minimumRooms = getMinimumRooms(intervalList);
    System.out.println("Minimum Rooms Required: " + minimumRooms);
  }
}
