class Solution {
    public int getMaxLen(int[] nums) {

        int positive = 0;
        int negative = 0;
        int ans = 0;

        for (int num : nums) {

            if (num > 0) {

                positive++;

                if (negative > 0)
                    negative++;
            }

            else if (num < 0) {

                int temp = positive;

               if (negative > 0)
                   positive = negative +1;
               else
                positive = 0;

                negative = temp +1;
            }

            else {

                positive = 0;
                negative = 0;
            }

            ans = Math.max(ans, positive);
        }

        return ans;
    }
}