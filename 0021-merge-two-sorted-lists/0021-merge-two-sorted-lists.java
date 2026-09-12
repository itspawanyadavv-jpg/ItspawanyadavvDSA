class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node makes it easier to build the result list.
        ListNode dummy = new ListNode(-1);

        // tail always points to the last node
        // in our merged list.
        ListNode tail = dummy;

        // Compare nodes while both lists have elements.
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                // Take the node from list1.
                tail.next = list1;

                // Move list1 forward.
                list1 = list1.next;

            } else {

                // Take the node from list2.
                tail.next = list2;

                // Move list2 forward.
                list2 = list2.next;
            }

            // Move tail to the node we just added.
            tail = tail.next;
        }

        // One list may still have remaining nodes.
        // Attach the entire remaining list.
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Dummy is not part of the answer.
        return dummy.next;
    }
}