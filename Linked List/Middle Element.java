/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A) {

        if(A.next==null)
                return A.val;

        ListNode slow=A,fast=A;

        while(fast.next!=null && fast!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow.val;
    }
}
