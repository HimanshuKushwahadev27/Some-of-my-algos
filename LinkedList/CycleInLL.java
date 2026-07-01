package LinkedList;

class ListNode {
      int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
public class CycleInLL {
  public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null)return false ;
        if(head.next == head)return true ;

        ListNode fast = head;
        ListNode slow = head ;

        while(fast != null  && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow)return true;
        }

        return false;
    }
}
