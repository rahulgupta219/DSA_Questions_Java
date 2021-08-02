Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
Given an arbitrary binary tree, convert it to a binary tree that holds such property :

->For every node, data value must be equal to sum of data values in left and right children.

->Consider data value as 0 for NULL children.

You can only increment data values in any node (You cannot change the structure of the tree and cannot decrement the value of any node).

NOTE

Your code will run on multiple test cases (<= 50)

CONSTRAINTS

1 <= Number of Nodes <= 500 1 <= Value at Node <= 2000

SAMPLE INPUT

     5
   /  \
  2    10
 / \   / \
 1  5  5  5
SAMPLE OUTPUT

    16
   /  \
  6    10
 / \   / \
 1  5  5  5

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    public void update(int val,TreeNode A)
    {
        if(A==null)
            return ;
        
        A.val=val;    
        
        int left_val=0;
        int right_val=0;
        
        if(A.left!=null)
            left_val= A.left.val;
        if(A.right!=null)
            right_val=A.right.val; 
        
        if(A.left!=null)
        {
            A.left.val=(A.val-right_val);
            update(A.left.val,A.left);
        }
        else if (A.right!=null) 
        {
            A.right.val=(A.val);
            update(A.right.val,A.right);
            
        }
        
    }
    public TreeNode solve(TreeNode A) {

        if(A.left==null && A.right==null)
            return A;
        
        int left_val=0;
        int right_val=0;
        
        if(A.left!=null)
            left_val= solve(A.left).val;
        if(A.right!=null)
            right_val=solve(A.right).val;
        
        if(A.val<left_val+right_val)
            A.val=left_val+right_val;
        else
            {
                update(A.val,A);
            }
    
    return A;
    }
}
