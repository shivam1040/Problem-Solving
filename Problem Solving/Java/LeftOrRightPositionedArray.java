/*
Given an array arr[] of size n>3, the task is to check whether the given array can be arranged in the form of a Left or Right positioned array?
Left or Right Positioned Array means each element in the array is equal to the number of elements to its left or number of elements to its right.
Note: 1 represents true and 0 represents false.

 

Example 1:

Input  : 
arr[] = {1, 3, 3, 2}
Output : 
1
Explanation :
This array has one such arrangement {3, 1, 2, 3}.
In this arrangement, first element '3' indicates
that three numbers are after it, the 2nd element
'1' indicates that one number is before it, the
3rd element '2' indicates that two elements are
before it.
 

Example 2:

Input : 
arr[] = {1, 6, 5, 4, 3, 2, 1}
Output :
0
Explanation :
No such arrangement is possible
 

Example 3:

Input : 
arr[] = {2, 0, 1, 3}
Output: 
1
Explanation :
Possible arrangement is {0, 1, 2, 3}
 

Example 4:

Input : 
arr[] = {2, 1, 5, 2, 1, 5}
Output : 
"1"
Explanation :
Possible arrangement is {5, 1, 2, 2, 1, 5}


Your Task:
You don't need to print anything, printing is done by the driver code. You have to complete the function leftRight() which takes the array arr[] and its size N as inputs and returns True if the array can be arranged to form left or right positioned array, else False as the answer.
 


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)



Constraints:
4 ≤ N ≤ 100000
0 ≤ arr[i] ≤ 1000


*/

/*
An efficient solution for this problem needs little bit observation and pen-paper work. To satisfy the Left or Right Positioned Array condition all the numbers in the array should either be equal to index, i or (n-1-i) and arr[i] < n. So we create an visited[] array of size n and initialize its element with 0. Then we traverse array and follow given steps :


If visited[arr[i]] = 0 then make it 1, which checks for the condition that number of elements on the left side of array arr[0]…arr[i-1] is equal to arr[i].
Else make visited[n-arr[i]-1] = 1, which checks for the condition that number of elements on the right side of array arr[i+1]…arr[n-1] is equal to arr[i].
Now traverse visited[] array and if all the elements of visited[] array become 1 that means arrangement is possible “YES” else “NO”.

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
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            
            if(obj.leftRight(a, n)==true)
            System.out.println(1);
            else
            System.out.println(0);
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

     // Function to check Left or Right Positioned
    // Array.
    // arr[] is array of n elements
    // visited[] is boolean array of size n
    public static boolean leftRight(int arr[],int n)
    {
        // Your code goes here
        int visited[]=new int[n];
        
        for(int i:arr)
            if(i<n)
                if(visited[i]==0)
                    visited[i]=1;
                else
                    visited[n-i-1]=1;
        for(int i:visited)
            if(i==0)
                return false;
        return true;
    }
}

