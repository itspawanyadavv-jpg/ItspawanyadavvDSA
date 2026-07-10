class Solution {
    public int removeDuplicates(int[] nums) {

        // If the array is empty, there are no unique elements.
        if (nums.length == 0) {
            return 0;
        }

        // 'i' points to the last unique element found so far.
        int i = 0;

        // 'j' scans the array from the second element onward.
        for (int j = 1; j < nums.length; j++) {

            // If we find a new unique element...
            if (nums[j] != nums[i]) {

                // Move 'i' to the next position.
                i++;

                // Place the new unique element at index 'i'.
                nums[i] = nums[j];
            }
        }

        

        // Number of unique elements is last index + 1.
        return i + 1;
    }
}

//BRUTE FORCE

// public int removeDuplicates(int[] nums) {

//     List<Integer> list = new ArrayList<>();

//     for (int num : nums) {

//         if (list.isEmpty() || list.get(list.size() - 1) != num) {
//             list.add(num);
//         }
//     }

//     for (int i = 0; i < list.size(); i++) {
//         nums[i] = list.get(i);
//     }

//     return list.size();
// }

