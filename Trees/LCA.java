Least Common Ancestor
Problem Description

Find the lowest common ancestor in an unordered binary tree A given two values B and C in the tree.

Lowest common ancestor : the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.

Problem Constraints
1 <= size of tree <= 100000

1 <= B, C <= 109

Input Format
First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.

Output Format
Return the LCA.



Example Input
Input 1:

 
      1
     /  \
    2    3
B = 2
C = 3
Input 2:

      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 LCA is 1.
Explanation 2:

 LCA is 2.

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
