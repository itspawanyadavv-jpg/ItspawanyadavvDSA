class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Dummy node makes it easy to handle left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Find the node just before the left position
        ListNode beforeLeft = dummy;

        for (int i = 1; i < left; i++) {
            beforeLeft = beforeLeft.next;
        }

        // First node of the section we want to reverse
        ListNode current = beforeLeft.next;

        // Move nodes to the front of the reversed section
        for (int i = 0; i < right - left; i++) {

            // Node that we will move
            ListNode nodeToMove = current.next;

            // Remove nodeToMove from its current position
            current.next = nodeToMove.next;

            // Insert nodeToMove at the front
            nodeToMove.next = beforeLeft.next;
            beforeLeft.next = nodeToMove;
        }

        // The head may have changed, so return dummy.next
        return dummy.next;
    }
}