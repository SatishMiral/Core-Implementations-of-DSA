package Overlapping_Intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Overlapping_Intervals {
    public static int[][] merge(int[][] intervals){

        // Step1:- Sort the Array based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step2:- Prepare a List to store the merged Intervals
        List<int[]> list = new ArrayList<>();

        // Step3:- Traverse the Intervals array & check if it overlaps
        for(int[] interval : intervals){
            if(list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]){ // prev.end < curr.start then no overlap
                list.add(interval);
            }
            else{
                int[] lastInterval = list.get(list.size() - 1);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
    
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {6, 10},
            {15, 18}
        };

        int[][] result = merge(intervals);

        for(int[] interval : result){
            System.out.println(Arrays.toString(interval));
        }
    }
}
