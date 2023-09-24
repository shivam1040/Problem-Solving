/*
An encoded string S consisting of alphabets(lowercase) and integers(1<=num<=9) is given, the task is to decode it and print the character at the 'K'th position in the string. The pattern in which the strings were encoded were as follows :
original string: jonjonsnowjonjonsnowjonjonsnow
encoded string: jon2snow3

Note: encoded string will always start with an alphabet and end with a number.

Example 1:

Input:
str = "jon2snow3"
k = 8

Output:
n

Explanation:
The given string after decoding it will be 
as such: jonjonsnowjonjonsnowjonjonsnow. 
8th character in the string after decoding is:'n'.
Example 2:

Input:
str = "q3"
k = 3

Output:
q

Explanation:
The given string after decoding it will be
as such: qqq. 3rd character in the string 
after decoding is:'q'.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function decodeIt() which takes the string str and an integer k as input parameters and returns the kth character of the mentioned string.

Expected Time Complexity: O(N), Where N is the size of the original string.
Expected Auxiliary Space: O(N)

Constraints:
2 <= |str| <= 35
1 <= k <= N
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t,i;
	    t=Integer.parseInt(br.readLine());
	    while(t-->0){
	        
	        String str=br.readLine();
	        int k=Integer.parseInt(br.readLine());
	        Solution ob = new Solution();
            System.out.println(ob.decodeIt(str, k));
            
	    }
	}
}
// } Driver Code Ends


class Solution{
    static char decodeIt(String str,int k){
        // Write your code here
        var temp="";
        var low=0;
        
        for(int i=0; i<str.length(); i++){
            var ch=str.charAt(i);
            if(Character.isDigit(ch)){
                var temp1=str.substring(low, i);
                low=i+1;
                temp=(temp+temp1).repeat(Character.getNumericValue(ch));
            }
        }
        return temp.charAt(k-1);
    }
}
