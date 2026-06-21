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
    static ListNode head;
    private static int getMinNode(){

      if(head == null){
           
          return Integer.MAX_VALUE;
      }
       
       ListNode temp = head;
       
       int min = temp.val;
       
       while(temp != null){
           
           min = Math.min(min,temp.val);
           temp = temp.next;
       }
       
       if(head.val == min){
           
           head = head.next;
           
           return min;
       }
       
       temp = head;
       
       while(temp.next != null){
           
           if(temp.next.val == min){
               
               temp.next = temp.next.next;
               return min;
           }
           
           temp = temp.next;
       }
       
       return min;
        
    }
    public ListNode insertionSortList(ListNode head) {
        
        Solution.head = head;

        ListNode dummy = new ListNode(-1);

        ListNode temp = dummy;

        int data = getMinNode();

        while(data != Integer.MAX_VALUE){

            ListNode newNode = new ListNode(data);
            temp.next = newNode;
            temp = temp.next;

            data = getMinNode();
        }

        return dummy.next;
    }
}