/*
Given an array arr[] of size N containing equal number of odd and even numbers. Arrange the numbers in such a way that all the even numbers get the even index and odd numbers get the odd index.
Note: There are multiple possible solutions, Print any one of them. Also, 0-based indexing is considered.

 

Example 1:

Input:
N = 6
arr[] = {3, 6, 12, 1, 5, 8}
Output:
1
Explanation:
6 3 12 1 8 5 is a possible solution.
The output will always be 1 if your
rearrangement is correct.
Example 2:
Input:
N = 4
arr[] = {1, 2, 3, 4}
Output :
1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function reArrange() which takes an integer N and an array arr of size N as input and reArranges the array in Place without any extra space.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 105
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            ob.reArrange(arr,N);
            
            System.out.println(check(arr,N));
        }
    }
    static int check(int arr[], int n)
    {
        int flag = 1;
        int c=0, d=0;
        for(int i=0; i<n; i++)
        {
            if(i%2==0)
            {
                if(arr[i]%2==1)
                {
                    flag = 0;
                    break;
                }
                else
                    c++;
            }
            else
            {
                if(arr[i]%2==0)
                {
                    flag = 0;
                    break;
                }
                else
                    d++;
            }
        }
        if(c!=d)
            flag = 0;
                
        return flag;
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void reArrange(int[] arr, int N) {
        // code here
        /*
        int res[]=new int[N];
        int odd=1, even=0;
        
        for(int i:arr){
            if(i%2==0){
                res[even]=i;
                even+=2;
            }
            else{
                res[odd]=i;
                odd+=2;
            }
        }
        for(int i=0; i<N; i++)
            arr[i]=res[i];
            */
            anotherWay(arr, N);
    }
    
    static void anotherWay(int[] arr, int N){
        int odd=1, even=0;
        
        while(true){
            while(even<N && arr[even]%2==0)
                even+=2;
            while(odd<N && arr[odd]%2!=0)
                odd+=2;
            if(even<N && odd<N){
                int temp=arr[even];
                arr[even]=arr[odd];
                arr[odd]=temp;
            }
            else
                break;
        }
    }
}
