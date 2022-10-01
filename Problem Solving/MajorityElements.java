/*
Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 

Example 1:

Input:
N = 3 
A[] = {1,2,3} 
Output:
-1
Explanation:
Since, each element in 
{1,2,3} appears only once so there 
is no majority element.
Example 2:

Input:
N = 5 
A[] = {3,1,3,3,2} 
Output:
3
Explanation:
Since, 3 is present more
than N/2 times, so it is 
the majority element.

Your Task:
The task is to complete the function majorityElement() which returns the majority element in the array. If no majority exists, return -1.
 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
 

Constraints:
1 ≤ N ≤ 107
0 ≤ Ai ≤ 106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        int count=0, candidate=0;
        
        //moore voting algorithm, the intuition is if anywhere in between the array the minority element which get eliminted by majority element(not matching a[i]!=a[i-], this means that number of majority is always eqaul to minority elements in between the array where non matching elements get cancelled. so at the end whichever element remains will obvisouly greater then number of previously cancelled majority/minority elements, hence majority element)
        for(int i:a){
            if(count==0)
                candidate=i;
            if(i==candidate)
                count+=1;
            else
                count-=1;
        }
        int check=0;
	
	//checking if actually majority        
        for(int i:a)
            if(i==candidate)
                check++;
        
        return check>size/2 ? candidate : -1;
    }
}
