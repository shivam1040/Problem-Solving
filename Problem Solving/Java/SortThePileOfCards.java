/*
We have n cards with each card numbered from 1 to n. All cards are randomly shuffled. We are allowed only operation moveCard(n) which moves the card with value n to the top of the pile. You are required to find out the minimum number of moveCard() operations required to sort the cards in increasing order.

 

Example 1:

Input:
n  = 5
a[] = {5, 1, 2, 3, 4}
Output:
4
Explanation:
5 1 2 3 4              //given sequence
4 5 1 2 3              //moveCard(4)
3 4 5 1 2              //moveCard(3)
2 3 4 5 1              //moveCard(2)
1 2 3 4 5              //moveCard(1)
Hence, minimum 4 operations are required.
 

Example 2:

Input:
n = 4
a[] = {3, 4, 2, 1}
Output:
2
Explanation:
3 4 2 1             //given sequence
2 3 4 1             //moveCard(2)
1 2 3 4             //moveCard(1)
Hence, minimum 2 operations are required.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function minOps() which takes the array a[] and its size n as inputs and returns the minimum number of operations required.

 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= n <=107 
1 <= a[i] <= n
*/

/*
Iterate from the end of the sequence and check how many elements are already in descending order starting from N, these are the elements which you don’t need to move. The rest of the elements needs to be moved which is the required minimum value.
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
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.minOps(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long minOps(long a[], long n)
    {
        long res=n;
        
        for(int i=(int)n-1; i>=0; i--)
            if(a[i]==res)
                res--;
        return res;
    }
}
