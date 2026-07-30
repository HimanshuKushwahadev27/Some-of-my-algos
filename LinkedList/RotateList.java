public class RotateList {
   public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return null ;
        if(k == 0 )return head ;

        int length = 0 ;
        ListNode curr = head ; 

        while(curr != null){
            length ++ ;
            curr = curr.next ;
        }

        if(k == length)return head ;
        int tra = k % length ; 
        if(tra == 0)return head ;

        ListNode prev = null ;
        curr = head ;

        for (int i = 1; i <= length; i++) {
            if (i == length - tra) prev = curr;
            if (i < length) curr = curr.next;
        }

        ListNode dummy = prev.next ;
        prev.next = null ;
        curr.next = head ;
        return dummy ;
    }
}
