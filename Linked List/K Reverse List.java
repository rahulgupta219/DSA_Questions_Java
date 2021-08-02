/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    public ListNode reverse(ListNode head, ListNode tail)
    {
    if(head==null || head.next==null || head==tail)
        return head;
    
    ListNode newhead = reverse(head.next,tail);
    
    head.next.next=head;
    head.next=null;
    
    return newhead;        
    }
    
    public ListNode reverseList(ListNode A, int B) {
    
    if(B==1)
        return A;

    int count=1,temp=A;

    //Storing Orignal Node for passing later
    ListNode head=null;

    while(temp!=null)
    {
        temp=temp.next;
        count++;
        if(count==B)
        {
            head=temp;
            break;
        }
    }

    
    temp=A;
    count=1;

    ListNode newhead =null,head_recursive=A,temp_duplicate=temp;

while(temp!=null)
    {

        if(count==1)
            head_recursive=temp;

        temp=temp.next;
        count++;
        if(count==B)
        {
            if(temp!=null)
            temp_duplicate=temp.next; 
            newhead = reverse(head_recursive,temp);
            head_recursive.next=reverse(    )

            count=1;


        }
    }







    return head;
    }
}
