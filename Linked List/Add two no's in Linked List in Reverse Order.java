/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
    
        int c=A.val+B.val;int carry=0;
        if(c>=10){c-=10;carry=1;}

    ListNode pa=A, pb=B, head= new ListNode(c);
    ListNode temp=head;
    ListNode new_node=null;

    pa=pa.next;
    pb=pb.next;

    while(pa!=null && pb!=null)
    {
        c=pa.val+pb.val+carry;
        if(c>=10)
            {c-=10;carry=1;}
        else
            carry=0;    
        new_node = new ListNode(c);
        temp.next=new_node;
        temp=temp.next;
        pa=pa.next;
        pb=pb.next;
    }

    ListNode final_add_node = null;

    if(pa!=null)
        final_add_node = pa;
    else
        final_add_node = pb;

    while(final_add_node!=null)
    {
        c=final_add_node.val+carry;
        if(c>=10)
            {c-=10;carry=1;}
        else
            carry=0;
        new_node = new ListNode(c);
        temp.next=new_node;
        temp=temp.next;
        final_add_node=final_add_node.next;
    }
    
    if(carry==1)
        {
           new_node = new ListNode(carry);
            temp.next=new_node; 
        }
    
    return head;
    }
}
