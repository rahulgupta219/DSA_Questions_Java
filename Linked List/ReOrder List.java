/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 /*
public class Solution {
    
    public ListNode findSecondLast(ListNode root)
    {
        if(root==null)
            return null;

        while(root.next!=null && root.next.next!=null)
            root=root.next;

        return root;
    }

    public void reOrder(ListNode head, ListNode prev_tail){

        if(head==null || head.next==null || prev_tail==null)
            return;

        ListNode newhead=head.next;
        head.next=prev_tail.next;
        head.next.next=newhead;
        prev_tail.next=null;
        prev_tail=findSecondLast(newhead);
        reOrder(newhead,prev_tail);
    }


    public ListNode reorderList(ListNode A) {
    
    if(A==null || A.next==null)
        return A;
    
        reOrder(A,findSecondLast(A));
    
    return A;
    }
}
*/

public class Solution {

public ListNode reorderList(ListNode A) {

    if(A==null || A.next==null)
        return A;

    Stack<ListNode> st = new Stack<ListNode>();

    ListNode temp=A,next_node=A.next,last_node=null;

    while(temp!=null)
    {   
        st.push(temp);
        temp=temp.next;
    }
    temp=A;

    while(temp!=null && !st.isEmpty() && temp.next!=st.peek() && temp!=st.peek())
    {
        next_node=temp.next;
        last_node=st.peek();
        temp.next=last_node;
        last_node.next=next_node;
        st.pop();
        //System.out.print(last_node.val+" ");
        if(!st.isEmpty())
            st.peek().next=null;
        else 
            break;
        temp=next_node;
    }
    
    
    return A;
    }
}

