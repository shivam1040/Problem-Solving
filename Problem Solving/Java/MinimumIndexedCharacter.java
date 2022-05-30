/*
Given a string str and another string patt. Find the minimum index of the character in str that is also present in patt.


Example 1:

Input:
str = geeksforgeeks
patt = set
Output: 1
Explanation: e is the character which is
present in given str "geeksforgeeks"
and is also presen in patt "set". Minimum
index of e is 1. 
Example 2:

Input:
str = adcffaet
patt = onkl
Output: -1
Explanation: There are none of the
characters which is common in patt
and str.

Your Task:
You only need to complete the function minIndexChar() that returns the index of answer in str or returns -1 in case no character of patt is present in str.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).


Constraints:
1 ≤ |str|,|patt| ≤ 105 
'a' <= stri, patti <= 'z'
*/

// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    
     // } Driver Code Ends
    //User function template for JAVA
    
    class Solution
    {
        //Function to find the minimum indexed character.
        public static int minIndexChar(String str, String patt)
        {
            Map<Character, Integer> aux=new HashMap<Character, Integer>();
            for(int i=0; i<str.length(); i++){
                if(!aux.containsKey(str.charAt(i)))
                    aux.put(str.charAt(i), i);
            }
            int min=Integer.MAX_VALUE;
            for(int i=0; i<patt.length(); i++)
                if(aux.containsKey(patt.charAt(i))){
                    if(aux.get(patt.charAt(i))<min)
                        min=aux.get(patt.charAt(i));
                }
            return min==Integer.MAX_VALUE ? -1 : min;
        }
    }
    
    // { Driver Code Starts.
    
    class GFG {
        public static void main (String[] args) 
        {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t>0)
            {
                t--;
                
                String s1=sc.next();
                String s2=sc.next();
                
                int res = new Solution().minIndexChar(s1, s2);
                System.out.println(res);
            }
        }
    }
      // } Driver Code Ends