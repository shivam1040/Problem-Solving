/*
Given a list of integers, rearrange the list such that it consists of alternating minimum-maximum elements using only list operations. The first element of the list should be the minimum of all elements and the second element should be a maximum of all elements present in the list. Similarly, the third element will be the next minimum element and the fourth element is the next maximum element, and so on. Use of extra space is not permitted. Store the answer in the answer[] array. You don't need to print that.

Note : All the elements in the array are unique.

Example 1:

Input
5
4 5 1 2 3
Output
1 5 2 4 3
Explanation:
In the first example minimum element is 1,
maximum element is 5, second minimum is
2 and so on, thus the rearranged array is
[1, 5, 2, 4, 3]
 

Example 2:

Input
4
1 2 3 4
Output
1 4 2 3 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function Rearrange() which takes the array A[] and its size N as inputs and stores the final modified list in the answer[].


Expected Time Complexity: O(N.log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 106
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
            int a[] = new int[n];
            int answer[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n, answer);
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
            output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static void Rearrange(int a[], int n, int answer[])
    {
        Arrays.sort(a);
        
        int index=0;
        int i=0;
        
        while(index<n){
            answer[index]=a[i];
            i++;
            index+=2;
        }
        
        index=1;
        i=n-1;
        
        while(index<n){
            answer[index]=a[i];
            i--;
            index+=2;
        }
        
        //return answer;
    }
}

