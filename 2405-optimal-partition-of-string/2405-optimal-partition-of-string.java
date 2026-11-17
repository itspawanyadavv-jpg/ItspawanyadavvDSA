
import java.util.Arrays;

class Solution {

    public int partitionString(String s) {

        // A non-empty string requires at least one partition.
        int partitions = 1;

        // Tracks characters in the current partition.
        boolean[] seen = new boolean[26];

        // Traverse the string from left to right.
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Convert character into an array index.
            int index = ch - 'a';

            // If the character already exists,
            // start a new partition.
            if (seen[index]) {

                partitions++;

                // Clear the previous partition's characters.
                Arrays.fill(seen, false);
            }

            // Include the current character
            // in the current partition.
            seen[index] = true;
        }

        return partitions;
    }
}
