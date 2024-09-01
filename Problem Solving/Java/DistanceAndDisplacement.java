/*
You are given two arrays of length n. An array a consisting of integers and another array d consisting of directions 'N', 'S', 'E', and 'W' denoting North, South, East, and West respectively.For every 'i' you move a[i] distance in d[i]th direction. You have to give the ceil of total distance covered through all the movements and then back to the starting  point. From the end of the journey you come to the starting point using the shortest distance.

Example 1:

Input: n = 3
a = {1, 3, 3}
d = {N, E, S}
Output: 11
Explaination: The total distance covered is 
ceil(1 + 3 + 3 + 3.6056) = 11.
Example 2:

Input: n = 4
a = {10, 10, 10, 10}
d = {N, E, S, W}
Output: 40
Explaination: The total distance covered is 
ceil(10 + 10 + 10 + 10 + 0) = 40.
Your Task:
You do not need to read input or print anything. Your task is to complete the function distance() which takes n, a, and d as input parameters and returns the ceil of total distance covered.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 1000
1 ≤ a[i] ≤ 1000
*/

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int distance(int n, int a[], char d[]){
        // code here
                int c=0,b=0,s=0;
        for(int i=0;i<n;i++){
            if(d[i]=='E')
            c+=a[i];
            if(d[i]=='W')
            c-=a[i];
            if(d[i]=='N')
            b+=a[i];
            if(d[i]=='S')
            b-=a[i];
            s+=a[i];
        }
        int m=c*c+b*b;
        return ceil(sqrt(m)+s);
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int a[n];
        char d[n];
        for(int i = 0;i < n;i++)
            cin>>a[i];
        for(int i = 0;i < n;i++)
            cin>>d[i];
            
        Solution ob;
        cout<<ob.distance(n, a, d)<<"\n";
    }
    return 0;
}
// } Driver Code Ends
