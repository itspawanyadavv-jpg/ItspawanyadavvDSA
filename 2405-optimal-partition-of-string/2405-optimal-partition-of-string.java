
class Solution {

    public int partitionString(String s) {

        // Tracks characters in the current substring.
        boolean[] seen = new boolean[26];

        // At least one partition is needed for non-empty input.
        int partitions = 1;

        for (int i = 0; i < s.length(); i++) {

            // Convert character into an array index.
            int index = s.charAt(i) - 'a';

            // Duplicate found: start a new partition.
            if (seen[index]) {

                partitions++;

                // Clear the previous partition's characters.
                seen = new boolean[26];
            }

            // Include the current character.
            seen[index] = true;
        }

        return partitions;
    }
}
