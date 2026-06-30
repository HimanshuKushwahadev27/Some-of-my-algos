package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
      public int[][] merge(int[][] intervals) {
        
        List<int[]> al = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int [] interval : intervals){
            if(al.isEmpty() || al.get(al.size()-1)[1] < interval[0] ){
                al.add(interval);
            }else{
                al.get(al.size()-1)[1] = Math.max(al.get(al.size()-1)[1], interval[1]);
            }
        }

        return al.toArray(new int[al.size()][]);
    }
}
