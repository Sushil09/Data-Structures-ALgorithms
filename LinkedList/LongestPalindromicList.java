package Questions.LinkedList_10;

public class LongestPalindromicList {
        public static void main(String[] args) {
        ListNode head=new ListNode(2);
        head.next=new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        head.next.next.next.next=new ListNode(2);
        head.next.next.next.next.next=new ListNode(2);
        head.next.next.next.next.next.next=new ListNode(2);
        System.out.println(maxNode(head));
    }
    static int maxNode(ListNode head){
        if(head==null)
            return 0;
        if(head.next==null)
            return 1;
        ListNode curr=head,prev=null;
        int ans=1;
        while(curr!=null){
            ListNode ahead=curr.next;
            curr.next=prev;
            ans=Math.max(ans,2*maxCommon(prev,ahead)+1);
            ans=Math.max(ans,2*maxCommon(curr,ahead));
            prev=curr;
            curr=ahead;
        }
        return ans;
    }
    static int maxCommon(ListNode ahead,ListNode prev){
            if(ahead==null || prev==null)
                return 0;
            int ans=0;
            ListNode trav1=ahead,trav2=prev;
            while (trav1!=null && trav2!=null){
                if(trav1.val==trav2.val)
                    ans++;
                else
                    break;
                trav1= trav1.next;
                trav2= trav2.next;
            }
            return ans;
    }
}
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
