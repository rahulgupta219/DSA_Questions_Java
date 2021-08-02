Min Depth of Binary Tree
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 NOTE : The path has to end on a leaf node and it is 2.
Example :

         1
        /
       2
min depth = 2.

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
    public int minDepth(TreeNode A) {
        
    if(A==null)
        return 0;
    
    int lst=minDepth(A.left);   
    int rst=minDepth(A.right);

    if(lst==0 || rst==0)
        return 1 + Math.max(lst,rst);

    return 1 + (Math.min(lst,rst));
        
    }
}








