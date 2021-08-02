Print all root to leaf paths
You are given a binary tree. Find all paths from root to leaves of the binary tree.


Input Format

The only argument given is the root pointer of tree A.
Output Format

Return all paths from root to leaf.
Constraints

1 <= number of nodes <= 50000
0 <= A[i] <= 10^9 
For Example

Input 1:
          5
         / \
        4   8
       /   / \
      11  13  4
     /      / 
    7      5  
Output 1:
 [
   [5,4,11,7],
   [5,8,13],
   [5,8,4,5]
]    


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
    
    ArrayList<Integer> list_path = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> final_list_path = new ArrayList<ArrayList<Integer>>();

    public void rootToLeaf(TreeNode A){

        if(A.left==null && A.right==null)
            {
                list_path.add(A.val);
                final_list_path.add(new ArrayList<Integer>(list_path));
                list_path.remove(list_path.size()-1);
               
            }

            list_path.add(A.val);
            if(A.left!=null)
                rootToLeaf(A.left);
            if(A.right!=null)
                rootToLeaf(A.right);
            list_path.remove(list_path.size()-1);

    }


    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
    
    rootToLeaf(A);
    
    return final_list_path;
    }
}
