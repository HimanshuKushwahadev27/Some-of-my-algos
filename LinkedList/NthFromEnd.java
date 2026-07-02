public class NthFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null)return null;
        if(head.next == null && n == 1) return null;

        int length = 0 ;

        ListNode curr = head ;

        while(curr != null){
            length++;
            curr = curr.next ;
        }


        int index = length - n ;
        curr = head ;
        ListNode prev = null;

        for(int i = 0 ; i < index ; i++){
            prev = curr ; 
            curr = curr.next;
        }


        if(prev != null){
            prev.next = curr.next ;
            return head ;
        }else{
            curr = curr.next ;
            return curr;
        }

    }
}
