class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals.length == 1)return 0;
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);


        int count = 1;

        int lastEnd = intervals[0][1];


        for(int i = 1; i<n; i++){


            if(intervals[i][0] >= lastEnd){
                count++;
                lastEnd = intervals[i][1];
            }
        }


        return intervals.length-count;
        
    }
}