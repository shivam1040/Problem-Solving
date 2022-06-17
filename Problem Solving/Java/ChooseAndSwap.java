/*
You are given a string s of lower case english alphabets. You can choose any two characters in the string and replace all the occurences of the first character with the second character and replace all the occurences of the second character with the first character. Your aim is to find the lexicographically smallest string that can be obtained by doing this operation at most once.

Example 1:

Input:
A = "ccad"
Output: "aacd"
Explanation:
In ccad, we choose a and c and after 
doing the replacement operation once we get, 
aacd and this is the lexicographically
smallest string possible. 
 

Example 2:

Input:
A = "abba"
Output: "abba"
Explanation:
In abba, we can get baab after doing the 
replacement operation once for a and b 
but that is not lexicographically smaller 
than abba. So, the answer is abba. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function chooseandswap() which takes the string A as input parameters and returns the lexicographically smallest string that is possible after doing the operation at most once.

Expected Time Complexity: O(|A|) length of the string A
Expected Auxiliary Space: O(1)

 

Constraints:
1<= |A| <=105
*/

// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String A = read.readLine().trim();
            
            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
    /*
    The idea here is to store distinct elements of string in Treeset, check every character of string against first element of set to ensure that the element from set is smaller and do remove the element from set whose check needs to be done because if we dont do that then there are chances of replacing char in string with bigger elements who have already been checked. for instance in string adcba, if we move to index of d and don't remove a from set then at d the set would return a as smallest element and as per ques all a would get replaced by d
    */
    
    String chooseandswap(String A){
        TreeSet<Character> aux=new TreeSet<Character>();
        for(int i=0; i<A.length(); i++)
            aux.add(A.charAt(i));
        
        for(int j=0; j<A.length(); j++){
            aux.remove(A.charAt(j));
            if(aux.isEmpty())
                break;
            char low=aux.first();
            //System.out.println(low);
            if(low<A.charAt(j)){
                char immediateHigh=A.charAt(j);
                for(int i=0; i<A.length(); i++){ //replacing loop
                    if(A.charAt(i)==low)
                        A=A.substring(0, i)+immediateHigh+A.substring(i+1);
                    else if(A.charAt(i)==immediateHigh)
                        A=A.substring(0, i)+low+A.substring(i+1);
                }
                break;
            }
        }
        return A;
    }
    
}