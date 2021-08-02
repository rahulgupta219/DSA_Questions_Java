/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    public ListNode makeList(Stack<ListNode> st, ListNode tail)
    {

        if(tail==null && !st.isEmpty())
            {
                tail=st.peek();
                st.pop();
            }


        while(!st.isEmpty())
        {
            tail.next=st.peek();
            st.pop();
            tail=tail.next;

            if(st.isEmpty())
                tail.next=null;
        }
        
        return tail;
    }

    public ListNode reverseList(ListNode A, int B) {
    
    if(B==1)
        return A;

    Stack<ListNode> st = new Stack<ListNode>();

    int count=1;
    ListNode temp=A,head=null,tail=null;

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
    count=0;

    while(temp!=null)
    {
        st.push(temp);
        temp=temp.next;
        count++;

        if(count==B)
        {
            count=0;
            tail=makeList(st,tail);
        }
    }

    return head;
    }
}
