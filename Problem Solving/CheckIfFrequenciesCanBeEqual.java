/*
Given a string s which contains only lower alphabetic characters, check if it is possible to remove at most one character from this string in such a way that frequency of each distinct character becomes same in the string.

Example 1:

Input:
s = xyyz
Output: 1 
Explanation: Removing one 'y' will make 
frequency of each letter 1.

Example 2:

Input:
s = xxxxyyzz
Output: 0
Explanation: Frequency can not be made same 
same by removing just 1 character.

Your Task:  
You dont need to read input or print anything. Complete the function sameFreq() which takes a string as input parameter and returns a boolean value denoting if same frequency is possible or not.
Note: The driver code print 1 if the value returned is true, otherwise 0.


Expected Time Complexity: O(N) where N is length of str
Expected Auxiliary Space: O(1)


Constraints:
1 <= str.length() <= 104
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        Map<Character, Integer> aux=new HashMap<>();
        List<Integer> aux2=new ArrayList<>();
        
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            aux.put(c, aux.getOrDefault(c, 0)+1);
        }
        for(int i:aux.values())
            if(!aux2.contains(i))
                aux2.add(i);
        //takes care if all freq are equal
        if(aux2.size()==1)
            return true;
        else if(aux2.size()>2)
            return false;
        int min=Math.min(aux2.get(0), aux2.get(1));
        int max=Math.max(aux2.get(0), aux2.get(1));
        //takes care if one character can be removed from multiple repeatitions
        if(max-min==1)
            return true;
        //takes care if only single character needs to be taken of
        else if(min==1)
            return true;
        return false;
    }
}
