package Intervals;

import java.util.Arrays;

public class MinimumArrows {
      public int findMinArrowShots(int[][] intervals) {
      
        if(intervals.length == 0)return 0 ;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        long arrowPos = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > arrowPos) {
                arrows++;
                arrowPos = intervals[i][1];
            }
        }

        return arrows;
    }
}
