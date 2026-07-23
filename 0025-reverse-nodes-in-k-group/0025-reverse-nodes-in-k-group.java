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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1)return head;

        ListNode temp = head;
        ListNode prev = null;

        while(temp!= null){

            ListNode kthNode = getKthNode(temp, k);

            if(kthNode == null){
                if(prev!=null){
                    prev.next = temp;
                    break;
                }

            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            

            if(temp == head){
                head = kthNode;
            }else{
                prev.next = kthNode;
            }
            
            temp.next = nextNode;

            prev = temp;
            temp = temp.next;
        }

        return head;
    }
    
     ListNode getKthNode(ListNode head, int k){
        ListNode temp = head;
        for(int i = 1; i< k; i++){
            temp = temp.next;
            if(temp == null)return null;
        }
        return temp;
    }

        ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}