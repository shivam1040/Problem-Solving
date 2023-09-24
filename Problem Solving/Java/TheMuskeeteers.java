/*
Given binary string str consisting of only 0's and 1's, Check if all the 0's are together or not.

Example 1:

Input:
str = "000"
Output:
YES
Explanation:
All the 0's are together.
Example 2:

Input:
str = "111"
Output:
NO
Explanation:
All the 0's are not together.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function checkTogether() which takes the binary string str as an input parameter and returns 1 if all the 0's are together else returns 0.

Expected Time Complexity: O(N), Where N is the size of the string.
Expected Auxiliary Space: O(1)

Constraints:
1 <= |str| <= 10000
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
	        
	        String str = br.readLine();
	        Solution ob = new Solution();
	        
            if(ob.checkTogether(str)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            
	    }
	}
}
// } Driver Code Ends


class Solution{
    static boolean checkTogether(String str){
        int first=str.indexOf('0'), last=str.lastIndexOf('0');
        
        if(first==-1)
            return false;
        for(int i=first+1; i<last; i++)
            if(str.charAt(i)!='0')
                return false;
        return true;
        
    }
}
