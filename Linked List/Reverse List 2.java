

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


    public ListNode reverseBetween(ListNode A, int B, int C) {

        if(A==null || A.next==null)
            return A;


        ListNode temp=A,start=null,end=null;

int count=1;

if(B==1)
    start=null;
else
{
//Getting the start node
        while(temp.next!=null)
        {
            count++;
            if(count==B)
                {
                    start=temp;
                    break;
                }
              
            temp=temp.next;    
        }
} 

count=1;

//Getting the end node
        temp=A;
        while(temp!=null)
        {   
            count++;
            temp=temp.next;
            if(count==C)
                {
                    end=temp.next;
                    break;
                }

            //temp=temp.next;    
        }
        
        ListNode old_head=null;
        if(start!=null)
            old_head = start.next;
        else
            old_head=A;
            
        //System.out.print(old_head.val+".."+temp.val+" ");    
        //System.out.println(temp.val+"..");    
        ListNode newhead = reverse(old_head,temp);
        //System.out.print(newhead.val+"..");
    
    //When starting is null  
    
    if(old_head==A) 
    {
        //old_head.next=end;
        A=newhead;
    } 
    else //When starting is in between
    {
        start.next=newhead;
    }
    
    old_head.next=end;
     
    return A;
    }
}
