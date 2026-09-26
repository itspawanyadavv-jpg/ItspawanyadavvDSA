class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Stack for digits of first number
        Stack<Integer> stack1 = new Stack<>();

        // Stack for digits of second number
        Stack<Integer> stack2 = new Stack<>();

        // Put all digits of l1 into stack1
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        // Put all digits of l2 into stack2
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;

        // Result starts as null
        ListNode result = null;

        // Process digits from right to left
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {

            int total = carry;

            // Get digit from stack1
            if (!stack1.isEmpty()) {
                total += stack1.pop();
            }

            // Get digit from stack2
            if (!stack2.isEmpty()) {
                total += stack2.pop();
            }

            // Calculate carry
            carry = total / 10;

            // Create new node with current digit
            ListNode node = new ListNode(total % 10);

            // Insert node at the beginning
            node.next = result;

            // Update result
            result = node;
        }

        return result;
    }
}