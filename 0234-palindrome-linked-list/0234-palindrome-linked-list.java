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
    public boolean isPalindrome(ListNode head) {

       if (head == null || head.next == null) {
            return true;
        }

        ListNode firstHead = head;
        ListNode secondHead = reverse(middle(head));
        while(secondHead != null){
            if(firstHead.val != secondHead.val) return false;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next  = null; 
        return newHead;
    }


    public ListNode middle(ListNode head){

        if(head == null) return null;
        if(head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}