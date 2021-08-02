Remove Loop from Linked List
Problem Description

Given a linked list which contains some loop.

You need to find the node, which creates a loop, and break it by making the node point to NULL.

Problem Constraints
1 <= number of nodes <= 1000

Input Format
Only argument is the head of the linked list.

Output Format
return the head of the updated linked list.

Example Input
Input 1:

1 -> 2
^    |
| - - 
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -
Example Output
Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL

Example Explanation
Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
    
    if(A==null)
        return null;

    ListNode slow=A,fast=A;
    
    //Using Do-While loop to start with the iteration
    
    do{
      slow=slow.next;  //Start Slow pointer
      fast=fast.next.next; //Start fast pointer
    }        
    while(slow!=fast);
    
    //Slow and fast meet at the node which is inside the loop
    
        ListNode temp=A;

    while(temp.next!=slow.next)
    {
        //Checking for the starting point.
        slow=slow.next;
        temp=temp.next;
    }

    slow.next=null; //Setting the loop point to null

    return A;    
        
    }
}
