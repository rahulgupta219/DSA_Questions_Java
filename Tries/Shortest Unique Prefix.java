Shortest Unique Prefix
Problem Description

Given a list of N words. Find shortest unique prefix to represent each word in the list.

NOTE: Assume that no word is prefix of another. In other words, the representation is always possible

Problem Constraints
1 <= Sum of length of all words <= 106

Input Format
First and only argument is a string array of size N.



Output Format
Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.



Example Input
Input 1:

 A = ["zebra", "dog", "duck", "dove"]
Input 2:

A = ["apple", "ball", "cat"]


Example Output
Output 1:

 ["z", "dog", "du", "dov"]
Output 2:

 ["a", "b", "c"]

Example Explanation
Explanation 1:

 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and "do" are prefixes of "dog".

Explanation 2:

 "a", "b" and "c" are not prefixes of any other word. So, we can use of first letter of each to represent.

public class Solution {

   class TrieNode{

      HashMap<Character,TrieNode> child;
      int count;

      TrieNode(){

         child = new HashMap<Character,TrieNode>();
         count=0;
      }

   }

   public void insert(TrieNode root, String word){

      char ch =' ';

      for(int i=0;i<word.length();i++){

         ch=word.charAt(i);

         if(!root.child.containsKey(ch))
            root.child.put(ch,new TrieNode());//Add the new character in the hashmap along with a new node

         root = root.child.get(ch);//Move to the next node
         root.count++; //Increment the count variable for the root node
   }

}
      public int uniqueCheck(TrieNode root, String word){

      char ch =' ';

      for(int i=0;i<word.length();i++){

         ch=word.charAt(i);

         root = root.child.get(ch);
         
   //If at anytime the root count is 1, meaning it is pointing to the unique string, return it
         if(root.count==1) 
            return i+1;
         
   }
   //Return -1 if no unique prefix, we will ignore the string then 
   return -1;
} 

    public ArrayList<String> prefix(ArrayList<String> A) {


      TrieNode root = new TrieNode();

      for(int i=0;i<A.size();i++)
         insert(root,A.get(i));

      ArrayList<String> result = new ArrayList<String>();

      int index=0;

      for(int i=0;i<A.size();i++)
      {
         index = uniqueCheck(root,A.get(i));
         //System.out.print(index+" ");
         if(index!=-1)  //If -1, means no unique string, then ignore it
            result.add(A.get(i).substring(0,index)); 
   //Since substring second index is exclusive, we are passing i+1, it will take string till i
      }

      return result;    
      }
}
