/*
Geek has an array Arr, where Arr[i] (1-based indexing) denotes the number of chocolates corresponding to each station. When he moves from station i to station i+1 he gets A[i] A[i+1] chocolates for free, if this number is negative, he looses that many chocolates also.
He can only move from station i to station i+1, if he has non-negative number of chocolates with him.
Given the cost of one chocolate Rs. P. Find the minimum cost incurred in reaching last station from the first station (station 1).
Note: Initially Geek has 0 chocolates.

 

Example 1:

Input:
N=3, price=10
arr[] = { 1, 2, 3 }
Output:  30
Explanation: 
To reach the first station from the starting
point, we need to buy 1 chocolate,To reach 
station 2 form station 1, we get A[1]  A[2]
= -1 chocolates i.e. we lose 1 chocolate. 
Hence, we need to buy 1 chocolate.Similarly, 
we need to buy 1 chocolate to reach station 3
from station 2.
Hence, total cost incurred = (1+1+1)*10 = 30
 

Example 2:

Input:
N=6, price=5
arr[] = { 10, 6, 11, 4, 7, 1 }
Output:  55
Explanation: 
To reach to the first station from starting
point he need to buy 10 chocolates. 
Chocolates Bought = 10,Chocolates balance = 0
On reaching second station he will get 
(10-6)= 4 chocolates.
Chocolates Bought= 10 , Chocolates balance = 4.
To reach to 3 station , he has to buy (6- 11) 
= 5 chocolates.But he has 4 chocolates as balance. 
So the chocolates he need to buy is (5 -4 ) =1;
Chocolates Bought= 11 , Chocolates balance = 0.
On reaching station 4 , he will get (11 - 4)= 7 
chocolates.
Chocolates Bought= 11 , Chocolates balance = 7.
To reach to 5 station , he has to buy (4- 7)= 3 
chocolates.
But he has 7 chocolates as balance .
Chocolates Bought= 11 , Chocolates balance = 4.
To reach to 6 station , he will get (7- 1) = 6
chocolates. 
Chocolates Bought= 11 , Chocolates balance = 10.
Therefore, total chocolates he has to buy is 11.
Hence, Amount=11*5=55.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getChocolateCost() that takes array arr and an integer chocolateMRP as parameters and returns the minimum cost.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 106
*/

//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class GFG
{
    long getChocolateCost(long arr[], int chocolateMRP)
    {
        long res=Long.MIN_VALUE;
        
        for(long i:arr)
            if(i>res)
                res=i;
        
        return res*chocolateMRP;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
//            String line = br.readLine();
//            String[] q = line.trim().split("\\s+");
//            int n =Integer.parseInt(q[0]);
//            int m =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
    //        int k = Integer.parseInt(br.readLine());
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[n];
//            for (int i = 0; i < n; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
            int k = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            long ans=ob.getChocolateCost(a,k);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends
