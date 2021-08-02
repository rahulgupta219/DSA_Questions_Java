Word Break II
Given a string A and a dictionary of words B, add spaces in A to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

Note : Make sure the strings are sorted in your result.

Input Format:

The first argument is a string, A.
The second argument is an array of strings, B.
Output Format:

Return a vector of strings representing the answer as described in the problem statement.
Constraints:

1 <= len(A) <= 50
1 <= len(B) <= 25
1 <= len(B[i]) <= 20
Examples:

Input 1:
    A = "b"
    B = ["aabbb"]

Output 1:
    []

Input 1:
    A = "catsanddog",
    B = ["cat", "cats", "and", "sand", "dog"]

Output 1:
    ["cat sand dog", "cats and dog"]


public class Solution {
    
    public HashSet<String> dict = new HashSet<String>();
    public ArrayList<String> string_list = new ArrayList<String>();
    

    public boolean findWordInDictionary(String word)
    {
        if(dict.contains(word))
            return true;

      return false;  
    }

    public boolean breakWords(String str, int start, String str_new){
        
        //Base Case
        if(start==str.length())
        {   
             string_list.add(str_new.trim());
            return true;    
        }

        for(int i=start;i<str.length();i++)
        {
            String word = str.substring(start,i+1);
            
            if(findWordInDictionary(word))
            {
                str_new+=word+" ";
                
                boolean ans = breakWords(str,i+1,str_new);
                
                str_new=str_new.substring(0,str_new.length()-word.length()-1); //This is the backtracking step 

            }
        }

 
    return true;
    }

    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {

    for(int i=0;i<B.size();i++)
    dict.add(B.get(i)); 
    
    boolean ans=breakWords(A,0,"");
    
    Collections.sort(string_list);
    
    return string_list;
    }
}
