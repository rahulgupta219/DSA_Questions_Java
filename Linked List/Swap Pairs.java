public class Solution {
    public ListNode swapPairs(ListNode A) {
    
    
       if(A==null || A.next==null)
        return A; 
       
        ListNode prev=A,curr=A.next,old=null;
        ListNode head=curr;
        while(prev!=null && curr!=null)
        {
            prev.next=curr.next;
            curr.next=prev;
            old=prev;
            prev=prev.next;

            if(prev!=null)
            {
            curr=prev.next;
            if(curr==null)
                old.next=prev;
            else
                old.next=curr;
            }

        }
    return head;
    }
}
