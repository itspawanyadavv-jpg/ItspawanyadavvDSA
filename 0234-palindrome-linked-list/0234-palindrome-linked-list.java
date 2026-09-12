class Solution {
    public boolean isPalindrome(ListNode head) {

        // 1. Find the middle of the linked list.
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half.
        ListNode secondHalf = reverse(slow);

        // 3. Compare the first half and reversed second half.
        ListNode firstHalf = head;

        while (secondHalf != null) {

            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            // Save the next node before changing the pointer.
            ListNode next = curr.next;

            // Reverse the pointer.
            curr.next = prev;

            // Move prev forward.
            prev = curr;

            // Move curr forward.
            curr = next;
        }

        return prev;
    }
}