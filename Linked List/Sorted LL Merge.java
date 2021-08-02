public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {

    if(A==null)
        return  B;
    if(B==null)
        return A;

ListNode head=null;

    if(A.val<B.val)
        {head=A;A=A.next;}
    else
        {head=B;B=B.next;}

        ListNode temp=head;
      while(A!=null && B!=null)  
      {
        if(A.val<B.val)
        {temp.next=A;temp=temp.next;A=A.next;}
    else
        {temp.next=B;temp=temp.next;B=B.next;}  

      }  

      while(A!=null)
      {
        temp.next=A;temp=temp.next;A=A.next;
      }

        while(B!=null)
      {
        temp.next=B;temp=temp.next;B=B.next
      }      

      return head;
    }
}