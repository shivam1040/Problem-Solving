/*
Given an integer S. Find the largest even number that can be formed by rearranging the digits of S.

Note: In case the number does not contain any even digit then output the largest odd number possible.

Example 1:

Input:
S = "1324"
Output: "4312"
Explanation: Largest even number: 4312
Example 2:

Input:
S = "3555"
Output: "5553"
Explanation: No even number possible,
So we'll find largest odd number.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function LargestEven() which takes the string S as inputs representing the integer and returns the answer.

Expected Time Complexity: O(|S| * log |S|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |S| ≤ 105
S contains only digits from '0' to '9'.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            String answer = ob.LargestEven(s);
            System.out.println(answer);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public String LargestEven(String S){
        char ch[]=S.toCharArray();
        
        Arrays.sort(ch);
        rvereseArray(ch, 0, ch.length-1);
        
        if(Integer.parseInt(String.valueOf(ch[ch.length-1])) % 2 ==0)
            return new String(ch);
        else{
            for(int i=ch.length-1; i>=0; i--){
                if(Integer.parseInt(String.valueOf(ch[i])) % 2 ==0){
                    char temp=ch[ch.length-1];
                    ch[ch.length-1]=ch[i];
                    ch[i]=temp;
                    Arrays.sort(ch, 0, ch.length-1);
                    rvereseArray(ch, 0, ch.length-2);
                    return new String(ch);
                }
            }
        }
        
        return new String(ch);
    }
    
    private void rvereseArray(char arr[],
                    int start, int end)
    {
        char temp;
          
        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }    
}
