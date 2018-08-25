/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
       if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = dummy.next;
            dummy.next = cur;
            
        }
        return dummy.next;
    }
}