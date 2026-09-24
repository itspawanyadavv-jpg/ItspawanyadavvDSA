class Solution {

    public ListNode sortList(ListNode head) {

        // Empty list or one node is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Second half starts after slow
        ListNode right = slow.next;

        // Break the list into two halves
        slow.next = null;

        // Sort both halves
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        // Merge the two sorted halves
        return merge(leftSorted, rightSorted);
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        // Attach remaining nodes
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }
}