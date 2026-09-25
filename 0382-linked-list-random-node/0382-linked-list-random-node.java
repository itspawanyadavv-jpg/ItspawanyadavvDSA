import java.util.Random;

class Solution {

    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {

        ListNode current = head;

        int count = 1;
        int result = head.val;

        while (current != null) {

            if (random.nextInt(count) == 0) {
                result = current.val;
            }

            current = current.next;
            count++;
        }

        return result;
    }
}