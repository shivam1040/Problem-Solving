/*
Given an array arr[] of n integers containing only 0 and 1. Write a program to find the minimum toggles (switch from 0 to 1 or vice-versa) required such the array the array become partitioned, i.e., it has first 0s then 1s. There should be at least one 0 in the beginning, and there can be zero or more 1s in the end.

Example 1:

Input: n = 5
arr = {1, 0, 1, 1, 0}
Output: 2
Explaination: The changed array will be 
{0, 0, 1, 1, 1}. So the number of toggles 
here required is 2.
Example 2:

Input: n = 7
arr = {0, 1, 0, 0, 1, 1, 1}
Output: 1
Explaination: The changed array will be 
{0, 0, 0, 0, 1, 1, 1}. Required toggles are 1.
Your Task:
You do not need to read input or print output. Your task is to complete the function minToggle() which takes n and arr as input parameters and returns the minimum number of toggles required to modify the array. 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ 100
*/

/*
If we observe the question then we will find that there will definitely exist a point from 0 to n-1 where all elements left to that point should contain all 0’s and right to point should contain all 1’s. Those indices which don’t obey this law will have to be removed. The idea is to count all 0s from left to right.  

Let zero[i] denotes the number of 0's till ith
index, then for each i, minimum number of
toggles required can be written as: i - zero[i]
 + zero[n] - zero[i] . The part i - zero[i]
indicates number of 1's to be toggled and the 
part zero[n] - zero[i] indicates number of 0's
to be toggled.

After that we just need to take minimum of 
all to get the final answer. 
*/

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int minToggle(int n, int arr[]){
        // code here
            int zero[n + 1]; 
    zero[0] = 0; 
  
    // Fill entries in zero[] such that zero[i] 
    // stores count of zeroes to the left of i 
    // (exl 
    for (int i = 1; i <= n; ++i) { 
        // If zero found update zero[] array 
        if (arr[i - 1] == 0) 
            zero[i] = zero[i - 1] + 1; 
        else
            zero[i] = zero[i - 1]; 
    } 
  
    // Finding the minimum toggle required from 
    // every index(0 to n-1) 
    int ans = n; 
    for (int i = 1; i <= n; ++i) 
        ans = min(ans, i - zero[i] + zero[n] - zero[i]); 
  
    return ans; 
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int arr[n];
        for(int i = 0;i < n;i++)
            cin>>arr[i];
        
        Solution ob;
        cout<<ob.minToggle(n, arr)<<endl;
    }
    return 0;
}
// } Driver Code Ends
