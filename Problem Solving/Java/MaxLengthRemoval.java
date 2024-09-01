/*
Given a binary string (consists of only 0 and 1). If there is “100” as a sub-string in the string, then we can delete this sub-string. The task is to find the length of longest sub-string which can be make removed?

Example 1:

Input  : 
str = "1011100000100"
Output :
6
Explanation :
Sub-strings present in str that can be make
removed 101{110000}0{100}. First
sub-string 110000-->100-->null, length is = 6.
Second sub-string 100-->null, length is = 3
 

Example 2:

Input  :
str = "111011"
Output :
0
Explanation :
There is no sub-string which can be make null.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function longestNull() which takes the string S[] as inputs and returns the length of the longest string that can be removed.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ string length ≤ 104
S[i] = {0, 1}


*/

/*
Take a vector arr of pair type. Each element in arr stores two values character and it’s respective index in string.
Store pair(‘@’,-1) as a base in arr. Take variable maxlen = 0 which stores the final result.
Now one by one iterate for all characters in string, make pair of characters and it’s respective index and store it in arr. In parallel also check the condition if after inserting i’th character last three elements of ‘arr’ are making sub-string “100”.
If sub-string exist then delete it from ‘arr’. Repeat this loop by number of times till you are getting sub-string “100” in arr and make it null by deleting continuously.
The difference of indexes of i’th character and index of last element currently present in arr after deletion gives the length of sub-string that can be make null by continuous deletion of sub-string “100”, update maxlen.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String s = new String(br.readLine());
            
            Solution obj = new Solution();
            System.out.println(obj.longestNull(s));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int longestNull(String str) 
    {
        // Your code goes here 
        //the que is to find the longest subsstring length that can be made null by continuous deletion of 100
        List<Pair> aux=new ArrayList<>();
        int res=0;

        aux.add(new Pair('@', -1));
        for(int i=0; i<str.length(); i++){
            aux.add(new Pair(str.charAt(i), i));

            if(aux.size()>=3 && aux.get(aux.size()-3).first=='1' && aux.get(aux.size()-2).first=='0' && aux.get(aux.size()-1).first=='0'){
                aux.remove(aux.size()-3);
                aux.remove(aux.size()-2);
                aux.remove(aux.size()-1);
            }

            int temp=aux.get(aux.size()-1).second;
            //this i-temp gives the index length deleted until now
            res=Math.max(res, i-temp);
        }
        return res;
    }
}

class Pair{
    char first;
    int second;

    Pair(char first, int second){
        this.first=first;
        this.second=second;
    }
}

