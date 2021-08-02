Sum binary tree or not
Problem Description

Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.

Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.

An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Return 1 if it sum-binary tree else return 0.


Problem Constraints
1 <= length of the array <= 100000

0 <= node values <= 50



Input Format
The only argument given is the root node of tree A.



Output Format
Return 1 if it is sum-binary tree else return 0.



Example Input
Input 1:

       26
     /    \
    10     3
   /  \     \
  4   6      3
Input 2:

       26
     /    \
    10     3
   /  \     \
  4   6      4


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 All leaf nodes are considered as SumTree. 
 Value of Node 10 = 4 + 6.
 Value of Node 3 = 0 + 3 
 Value of Node 26 = 20 + 6 
Explanation 2:

 Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.



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
        
    public class Info{
    int value;
    boolean sumtree;

    Info(int x, boolean returned_check){
        this.value=x;
        this.sumtree=returned_check;
    }

}
    
    public Info checkSumTree(TreeNode root)
    {

        if(root==null)
            return new Info(0,true);
                
        Info left = checkSumTree(root.left);
        Info right = checkSumTree(root.right);

        if(root.left==null && root.right==null)
            return new Info(root.val,true);

        int sum_at_node = left.value+right.value+root.val;

        if(left.sumtree==false || right.sumtree==false)
            return new Info(sum_at_node,false);
        else if(left.value + right.value!=root.val)
            return new Info(sum_at_node,false);

        return new Info(sum_at_node,true);
    }


    public int solve(TreeNode A) {

        if(A==null)
            return 0;

     Info result = checkSumTree(A);   

    if(result.sumtree==true)
        return 1;
    return 0;
    }
}
