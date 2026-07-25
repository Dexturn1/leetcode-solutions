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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        int count = count(head);
        k = k % count;
        if(k == 0)return head;

        head = reverse(head);
    
        ListNode p = head;

        for(int i = 1; i<k; i++){
            p = p.next;
        }

        ListNode nextNode = p.next;
        p.next = null;

        ListNode prev = head;
        head =   reverse(head);
        nextNode = reverse(nextNode);

        prev.next = nextNode;
        
        return head;
    }

    ListNode reverse(ListNode head){
        if(head == null || head.next == null )return head;

        ListNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null; 
        return newHead;
    }
    
    int count(ListNode head){
        int count = 0;

        while(head != null){
            count++;
            head = head.next;
        }

        return count;
    }
}