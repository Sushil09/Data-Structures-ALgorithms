package Questions.LinkedList_10;

public class RemoveNodeFromEnd {
    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        head.next=new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        head.next.next.next.next=new ListNode(2);
        head.next.next.next.next.next=new ListNode(2);
        head.next.next.next.next.next.next=new ListNode(2);
        int n=2;
        head=removeNode(head,n);
    }
    static ListNode removeNode(ListNode head,int k){
        if(head==null)
            return null;
        ListNode trav=head;
        int size=calcSize(head);
        int reduced=size-k;
        //head case
        if(reduced==0)
            head=head.next;
        else{
            while(--reduced>0 && trav!=null)
                trav=trav.next;
            trav.next=trav.next.next;
        }
        return head;
    }
    static int calcSize(ListNode head){
        if(head==null)
            return 0;
        int c=1;
        while(head.next!=null){
            c++;
            head=head.next;
        }
        return c;
    }
}
