
public class RandomPointer {
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

      public Node copyRandomList(Node head) {
        if (head == null) return null; 
        
        Node helper = head ;
        

        while(helper != null){
            Node node = new Node(helper.val);
            node.next = helper.next;
            helper.next = node;
            helper = node.next;
        }

        helper = head ;

        while(helper!=null){
            if(helper.random!=null){
                helper.next.random = helper.random.next;
            }
            helper = helper.next.next;
        }

        helper = head ;
        Node result = head.next ;
        Node copy = result ;

        while(helper != null){
            helper.next = helper.next.next ;
            copy.next = (copy.next != null) ? copy.next.next : null;
            helper = helper.next ;
            copy = copy.next ;
        }
        
        return result ;
    }
}
