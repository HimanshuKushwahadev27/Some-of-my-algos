public class ReverseLL {
   public ListNode reverseBetween(ListNode head, int left, int right) {
        
     if (head == null || left == right) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;
    for (int i = 0; i < left - 1; i++) {
        prev = prev.next;
    }

    ListNode curr = prev.next;

    for (int i = 0; i < right - left; i++) {
        ListNode toMove = curr.next;
        curr.next = toMove.next;
        toMove.next = prev.next;
        prev.next = toMove;
    }

    return dummy.next;


    }
}
