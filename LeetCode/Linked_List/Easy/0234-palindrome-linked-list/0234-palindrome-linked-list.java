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
        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode p = head;
        while(p!=null){
            stack.push(p);
            p=p.next;
        }
        
        p = head;
        while(p!=null){

            if(p.val != stack.pop().val)
                return false;

            p = p.next;   
        }

        return true;

    }
}