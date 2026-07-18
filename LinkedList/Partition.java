public class Partition {
  public ListNode partition(ListNode head, int x) {
        
        if(head == null)return null ;

        
        ListNode dummy = new ListNode(0) ;
        ListNode res = dummy ;
        ListNode curr = head ;

        while(curr != null){
            
            if(curr.val < x){
                res.next = new ListNode(curr.val);
                res = res.next ;
            }
            curr = curr.next;
        }

        curr = head ;

        while(curr != null){

            if(curr.val >= x){
                res.next = new ListNode(curr.val);
                res = res.next ;
            }
            curr = curr.next;
        }

        return dummy.next ;
    }
}
