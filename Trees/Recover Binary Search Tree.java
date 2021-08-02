Recover Binary Search Tree
Problem Description

Two elements of a binary search tree (BST),represented by root A are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.

A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the head of the tree,A

Output Format
Return the 2 elements which need to be swapped.

Example Input
Input 1:

 
         1
        / \
       2   3
Input 2:

 
         2
        / \
       3   1

Example Output
Output 1:

 [2, 1]
Output 2:

 [3, 1]


Example Explanation
Explanation 1:

Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
Explanation 2:

Swapping 1 and 3 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 


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
/* Using O(N) Space
public class Solution {
       
    public TreeNode first=null;
    public TreeNode last=null;
    
    Using O(N) Space
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    return;        
    }
    
    public int[] recoverTree(TreeNode A) {
    
    inorder(A);
    
    TreeNode first=null,last=null;
    
    for(int i=0;i<list.size()-1;i++)
    {
        if(list.get(i).val>list.get(i+1).val)
        {
            if(first==null)
            {
                first=list.get(i);
                last=list.get(i+1);
            }
            else
                last=list.get(i+1);
        }
            
    }
        
    int recover[]=new int[2];

    recover[1]=first.val;
    recover[0]=last.val;

    return recover;    
    
    }
}
    
    */
public class Solution {
    
    public TreeNode first=null,last=null,prev=null;

    public void swapped(TreeNode root){

        if(root==null)
            return;

        swapped(root.left);

        if(prev!=null && prev.val>root.val)
        {
            if(first==null)
                    first=prev;                    

                last=root;
        }


        prev=root; // Before moving to the right subtree, setting root node as the previous node for the operation
        swapped(root.right);


    }



    public TreeNode findNode(TreeNode root){

        if(root==null)
            return;

        if(root.left==null && root.right==null)
            return root;

        TreeNode prev=null,next=null;

        if(root.left!=null)
        {
            prev = findNode(root.left);

            if(root.val < prev.val)
            {   
                if(first==null)
                    first=prev;                    

                last=root;
            }

        }
        if(root.right!=null)
        
        next = findNode(root.right);

    if(prev==null)
        return next;
    else
        return root;

    }
    
    public int[] recoverTree(TreeNode A) {  

    TreeNode root = findNode(A);

    int recover[]=new int[2];

    recover[1]=first.val;
    recover[0]=last.val;

    return recover;
    }   
}

