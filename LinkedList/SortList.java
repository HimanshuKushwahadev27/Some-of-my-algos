import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {
    List<Integer> list = new ArrayList<>();

    public void helper(ListNode head){
        if(head == null)return ;

        list.add(head.val);
        helper(head.next);
    }
    public ListNode sortList(ListNode head) {
        if(head == null)return head ;
        helper(head);

        Collections.sort(list);
        ListNode result = new ListNode(-1);
        ListNode curr = result ;
        for(int i : list){
            curr.next = new ListNode(i);
            curr = curr.next ;

        }

        return result.next ;
    }
}
