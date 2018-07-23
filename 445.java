/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            s1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.push(p2.val);
            p2 = p2.next;
        }
        int sum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            int value = sum % 10;
            ListNode newNode = new ListNode(value);
            newNode.next = dummy.next;
            dummy.next = newNode;
            sum /= 10;
        }
        if (sum == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }
}