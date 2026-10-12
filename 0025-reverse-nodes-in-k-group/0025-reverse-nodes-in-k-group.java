
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Step 1: Find the kth node of the current group
        ListNode kth = head;

        for (int i = 1; i < k; i++) {
            if (kth == null) {
                return head;
            }
            kth = kth.next;
        }

        // If fewer than k nodes remain, do not reverse them
        if (kth == null) {
            return head;
        }

        // Save the first node after this group
        ListNode groupNext = kth.next;

        // Step 2: Reverse the current group
        ListNode prev = groupNext;
        ListNode curr = head;

        while (curr != groupNext) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Recursively process the remaining groups
        head.next = reverseKGroup(groupNext, k);

        // The kth node is now the new head of this group
        return kth;
    }
}
