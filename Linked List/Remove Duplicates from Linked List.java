/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {

        if(A==null || A.next==null)
            return A;

        ListNode temp = A,next_node=temp.next;

        while(temp!=null && next_node!=null)
        {
            if(next_node.val==temp.val)
                temp.next=next_node.next;
            else
                temp=temp.next;

            next_node=temp.next;

        }
        return A;
    }
}