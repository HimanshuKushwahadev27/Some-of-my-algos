public class DeleteDuplicates {
   public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null)return null ;

        ListNode dummy = new ListNode(0);
        dummy.next = head ;
        ListNode curr = head ;
        ListNode prev = dummy ;

        while(curr != null){
            boolean flag = false ;
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next ;
                    flag = true;
                }
            
            if(flag){
                prev.next = curr.next ;
            }else {
                prev = prev.next ; 
            }
            curr = curr.next ;
        }

        return dummy.next ;
    }
}
