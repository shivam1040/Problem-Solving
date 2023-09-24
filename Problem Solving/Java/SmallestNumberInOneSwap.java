/*
Given a non-negative number N. The task is to apply at most one swap operation on the number N so that the result is the smallest possible number.
Note: Input and Output should not contain leading zeros.

Example 1:

Input: N = "9625635"
Output: "2695635"
Explanation: Swapped the digits 9 and 2.
Example 2:

Input: N = "1205763"
Output: "1025763"
Explanation: Swapped the digits 0 and 2.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function smallestNumber() which takes the string as inputs and returns the answer.

Expected Time Complexity: O(|N|)
Expected Auxiliary Space: O(|N|)

Constraints:
1 ≤ |N| ≤ 105
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.smallestNumber(s));                        
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public String smallestNumber(String numx)
    {
        int n=numx.length();
       //code here.
       //this array contains the smallest element to the right of num[i] smaller than num[i]
       int[] arr =new int[n];

       int midx=n-1,idx=0;
       char[] num =numx.toCharArray();

       for(int i=n-1;i>=0;i--){
           if(num[idx]>num[i] && num[i]!='0')
               idx=i;
           if(num[midx]>num[i]){
               midx=i;
           }
           arr[i]=midx;
       }
       if(idx!=0){
           char temp = num[idx];
           num[idx]=num[0];
           num[0]=temp;
           return new String(num);
       }
       //this loop takes care when the first digit is 1 so that it smallest of every digit in num array as per the rule of no leading zero, but let's say there is zero present in mid of the num array or some digit which is just greater than the first digit then swapping can give us smallest posssible number
       // int this loop we find the first digit which is greater than the second smallest digit and do swap
       for(int i=1;i<n;i++){
           if(num[i]>num[arr[i]]){
               char temp=num[i];
               num[i]=num[arr[i]];
               num[arr[i]]=temp;
               break;
           }
       }
       return new String(num);
    }
}




