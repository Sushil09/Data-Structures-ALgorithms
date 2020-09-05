package Questions.LinkedList_10;

public class ReverseKList {
    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        head.next=new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        head.next.next.next.next=new ListNode(2);
        head.next.next.next.next.next=new ListNode(2);
        head.next.next.next.next.next.next=new ListNode(2);
    }
    static ListNode reverseLL(ListNode head, int k){
        if(k>size(head))
            return head;
        ListNode trav=head,prev=null,ahead=null;
        int count=1;
        while(count<=k && trav!=null){
            ahead=trav.next;
            trav.next=prev;
            prev=trav;
            trav=ahead;
            count++;
        }
        if(trav!=null)
            head.next=reverseLL(trav,k);
        return prev;
    }
    static int size(ListNode head){
        if(head==null)
            return 0;
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}
