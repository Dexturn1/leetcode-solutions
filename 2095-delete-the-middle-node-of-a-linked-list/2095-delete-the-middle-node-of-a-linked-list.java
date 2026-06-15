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
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head; 
        ListNode slow = head;
        ListNode p = null;

        if (head == null || head.next == null) {
            return null;
        }
         
        while(fast!=null && fast.next!=null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        p.next = slow.next;
         return head;

    }
}