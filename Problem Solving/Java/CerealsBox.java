/*
You are given N numbers you can decrease each number by 10 % or K kg whichever is more. If the number you choose is less than K you can make it zero. Your task is to minimize the sum of the number as small as possible by performing N operations only

Note: Final answer should be typecasted to the nearest integer smaller or equal to the value.
 

Example 1:

Input:
N = 2
k = 10
arr = 100 15
Output:
95
Explanation:
You will remove 10 from 100
then once again remove 10 
90.
Example 2:

Input:
N = 2
K = 10
arr = 90 100
Output
170
Explanation:
remove 10 each time
from either 100 or 90.

Your Task:
You don't need to read input or print anything. Your task is to complete the function minSum() which takes an array of integer, its size N, and an integer K  as input parameters and returns an integer, minimum sum of all the elements after performing N operations.


Expected Time Complexity: O(log N)
Expected Space Complexity: O(1)
 

Constraints:
1<=N,K<=104
1<=A[i]<=106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int N = s.nextInt();
            int K = s.nextInt();
            int a[] = new int[N];
            for(int i = 0;i<N;i++)
            {
                a[i] = s.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.minSum(a,N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long minSum(int a[], int N, int K){
        // code here
        PriorityQueue<Double> aux = new PriorityQueue<>(Collections.reverseOrder());
        int temp=0;
        double res=0;
        
        for(int i:a)
            aux.add((double)i);
        while(temp<N){
            double temp1=aux.poll();
            
            if(temp1<K)
                temp1=0;
            else{
                double temp2=.1*temp1;
                
                if(temp2>K)
                    temp1-=temp2;
                else
                    temp1-=K;
            }
            aux.add(temp1);
            temp++;
        }
        for(double i:aux)
            res+=i;
        //System.out.println(Math.floor(res));
        return (long)res;
    }
}
