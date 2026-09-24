class Solution {
    public ListNode oddEvenList(ListNode head) {

        // 0 or 1 node: nothing to rearrange
        if (head == null || head.next == null) {
            return head;
        }

        // First node is odd
        ListNode odd = head;

        // Second node is even
        ListNode even = head.next;

        // Remember the beginning of the even list
        ListNode evenHead = even;

        // Continue while there is another odd node
        while (even != null && even.next != null) {

            // Connect current odd node to the next odd node
            odd.next = even.next;

            // Move odd pointer forward
            odd = odd.next;

            // Connect current even node to the next even node
            even.next = odd.next;

            // Move even pointer forward
            even = even.next;
        }

        // Attach the even list after the odd list
        odd.next = evenHead;

        return head;
    }
}