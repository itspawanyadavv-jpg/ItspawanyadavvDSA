class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            // If current and next nodes have the same value,
            // next is a duplicate.
            if (curr.val == curr.next.val) {

                // Skip the duplicate node.
                curr.next = curr.next.next;

            } else {

                // No duplicate, so move forward.
                curr = curr.next;
            }
        }

        // Return the original head.
        return head;
    }
}