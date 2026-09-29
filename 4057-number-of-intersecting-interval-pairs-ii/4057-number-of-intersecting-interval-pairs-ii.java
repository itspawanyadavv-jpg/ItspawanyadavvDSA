class Solution {
    public long countIntersectingIntervals(int[][] intervals) {

        int n = intervals.length;

        int [] s = new int[n];
        int [] e = new int[n];

        for(int i = 0; i < n; i++){
            s[i] = intervals[i][0];
            e[i] = intervals[i][1];

        }
        Arrays.sort(s);
        Arrays.sort(e);

        long ans = 0;
        int j = 0;

        for(int i =0; i < n; i++  ){
            while(j < n && e[j]  < s[i]){
                j++;
            }

            ans += i - j ;

        
        }

     return ans;

        
    }
}