Symmetric Binary Tree
Problem Description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is the root node of the binary tree.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ).



Example Input
Input 1:

    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:

    1
   / \
  2   2
   \   \
   3    3


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The above binary tree is symmetric. 
Explanation 2:

The above binary tree is not symmetric.


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
    
    public boolean symmetric(TreeNode left, TreeNode right){
        
        if(left==null && right ==null)
            return true; //If both are null, then yes, it will count as symmetric
        if(left==null || right ==null)
            return false; //If one of them is null, then it will not be symmetric
        if(left.val!=right.val)
            return false; //If values don't match, they are not symmetric 
        
        return symmetric(left.left,right.right) && symmetric(left.right, right.left);//Checking for symmetry for the left and right branches
    }
    
    public int isSymmetric(TreeNode A) {
        
    if(A==null)
        return 0;
        
    return symmetric(A.left,A.right)?1:0;    
    }
}
