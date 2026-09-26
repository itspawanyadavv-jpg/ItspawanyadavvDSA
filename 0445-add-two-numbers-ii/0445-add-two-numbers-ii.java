import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode head = null;
        
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int total = carry;
            if (!s1.isEmpty()) total += s1.pop();
            if (!s2.isEmpty()) total += s2.pop();
            
            carry = total / 10;
            int digit = total % 10;
            
            ListNode node = new ListNode(digit);
            node.next = head;
            head = node;
        }
        
        return head;
    }
}