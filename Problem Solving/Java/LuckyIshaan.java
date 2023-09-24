/*
Ishaan has bought N lottery tickets each having an ID denoted by an array A. As a result comes out, Ishaan gets very lucky and gets to know that each one of his tickets has won some prize. But unfortunately, he can't claim all of his lottery tickets.
The "sum_id" of a lottery ticket is the sum of the individual digits of the ticket ID. For example, sum_id of a ticket with ID = 1234 is 1+2+3+4 = 10.
Ishaan can claim the prize of a ticket only if no other ticket with the same sum_id has been claimed by him yet (Refer to example for explanation).
Find out the maximum number of tickets he can claim.

Example 1:

Input:
arr[ ] = {123, 42, 45, 78, 12345}
Output : 3
Explanation:
sum_id of Ticket 1: 1+2+3 = 6 (claimed)
sum_id of Ticket 2: 4+2 = 6 (can't be claimed since Ticket 1, with same sum_id has already been claimed)
sum_id of Ticket 3: 4+5 = 9 (claimed),
sum_id of Ticket 4: 7+8 = 15 (claimed),
sum_id of Ticket 5: 1+2+3+4+5 = 15
(can't be claimed since Ticket 4 with the same sum_id has already been claimed)

Example 2:

Input: 
arr[ ] = {2, 3, 4, 6, 22, 8} 
Output: 5 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function lucky() that takes an array (arr), sizeOfArray (n), and return the maximum number of tickets he can claim. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints :
1 ≤ N ≤ 5000
1 ≤ A[i] ≤ 1015
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    long arr [] = new long[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Long.parseLong(elements[i]);    
	        }
		    
		    Complete obj = new Complete();
		    int ans = obj.lucky(arr, N);
        	System.out.println(ans);
		}
	}
}








// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static int lucky (long arr[], int n) {
        //Complete the function
        Set<Long> aux=new HashSet<>();
        
        for(long i:arr)
            aux.add(sum(i, 0));
        return aux.size();
    }
    
    private static long sum(long n, long val)
    {
        if (n < 10) {
            val = val + n;
            return val;
        }
        return sum(n / 10, (n % 10) + val);
    }
    
    
}

