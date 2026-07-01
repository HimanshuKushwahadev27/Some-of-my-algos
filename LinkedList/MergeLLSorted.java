public class MergeLLSorted {
   public class ListNode {
      int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode node = new ListNode();
        ListNode head = node ;
        
        while(list1 != null && list2 != null){
            
            while((list1 != null && list2 != null) &&   list1.val <= list2.val){
                
                head.next = new ListNode(list1.val);
                head = head.next ;
                list1 = list1.next ;
            }

            if(list1 != null && list2 != null){
                
                while((list1 != null && list2 != null) && list2.val <= list1.val ){
                    head.next = new ListNode(list2.val);
                    head = head.next;
                    list2 = list2.next;
                }
            }
        }

        while(list1 != null){
            head.next = new ListNode(list1.val);
            head = head.next ; 
            list1 = list1.next ;
        }

        while(list2 != null){
            head.next = new ListNode(list2.val);
            head = head.next ; 
            list2 = list2.next ;
        }

        return node.next;
    }
}
