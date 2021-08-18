Problem Description

Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if it is not.

Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.



Problem Constraints
1 <= |A| <= 1000

1 <= sum of all strings in A <= 50000

1 <= |B| <= 1000



Input Format
First argument is array of strings A.

First argument is array of strings B.



Output Format
Return the binary array of integers according to the given format.



Example Input
Input 1:

A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
Input 2:

A = [ "tape", "bcci" ]
B = [ "table", "cci" ]


Example Output
Output 1:

[1, 0]
Output 2:

[0, 0]


Example Explanation
Explanation 1:

Only "cat" is present in the dictionary.
Explanation 2:

None of the words are present in the dictionary.





public class Solution {
    
    public class TrieNode{
    HashMap<Character,TrieNode> child; //Declaring child of TrieNode
    boolean isEnd; // For checking the end node of a string

    TrieNode(){
        child = new HashMap<Character,TrieNode>();
        isEnd=false;
    }
}
    
    public int search(TrieNode root, String word){

        char ch=' ';

        for(int i=0;i<word.length();i++)
        {
            ch=word.charAt(i);

            if(!root.child.containsKey(ch)) //HashMap does not contain the character
                return 0;
            root = root.child.get(ch); //Move to the next node
        }

        if(root.isEnd) //If the node now is the end node, return 1
            return 1;
    return 0;   //If search unsuccessful, return 0
    }

    public void insert(TrieNode root, String word){

        char ch=' ';

        for(int i=0;i<word.length();i++)
        {
            ch=word.charAt(i);

            if(!root.child.containsKey(ch))
                root.child.put(ch,new TrieNode()); //Add the new character in the hashmap along with a new node
            root = root.child.get(ch); //Move to the next node
        }

        root.isEnd = true; //Setting the end node 
    }


    public int[] solve(String[] A, String[] B) {

        TrieNode root = new TrieNode();
        TrieNode temp = root;

        for(int i=0;i<A.length;i++){

            //Insert word in Trie
            insert(root,A[i]);
        }

        int result[]=new int[B.length];

        for(int i=0;i<B.length;i++)
            result[i]=search(root,B[i]); //Insert whatever value is required in the resulting array

    return result;
    }
}
