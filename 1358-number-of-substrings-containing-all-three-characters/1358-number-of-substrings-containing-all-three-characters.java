class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();
        int answer = 0;
        int left = 0;

        int[] freq = new int[3];

        for(int right = 0; right < n; right ++){
            //Add the curr character to the window.

            freq[s.charAt(right) - 'a']++;

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                answer += n - right ;
                //remove the left most character.
                freq[s.charAt(left) - 'a']--;
                left ++; 

            }

        }
        return answer;
    }
}