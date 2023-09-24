/*
Tywin Lannister is facing a war. He has N troops of soldiers. Each troop has a certain number of soldiers denoted by an array A.
Tywin thinks that a troop is lucky if it has a number of soldiers as a multiple of K. He doesn't want to lose any soldiers, so he decides to train some more.
He will win the war if he has at least half of his troops are lucky troops.
Determine the minimum number of soldiers he must train to win the war.

Example 1:

Input : arr[ ] = {5, 6, 3, 2, 1} and K = 2
Output : 1
Explanation:
Troop with 1 soldier is increased to 2.

Example 2:

Input : arr[ ] = {2, 3, 4, 9, 8, 7} and K = 4
Output :  1
Explanation:
Troop with 3 soldier is increased to 4. 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function min_soldiers() that takes an array (arr), sizeOfArray (n), an integer K, and return the minimum number of soldiers he must train to win the war. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(1).

 

Constraints :
1 ≤ N, K ≤ 105
1 ≤ Ai ≤ 105`:
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
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    int ans = obj.min_soldiers(arr, sizeOfArray, K);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static int min_soldiers (int arr[], int n, int K) {
        //Complete the function
        for(int i=0;i<n;i++)
       {
           //storing the required number to achieved 0 mod
         arr[i]=(K-arr[i]%K)%K;                  
       }
       Arrays.sort(arr);
       int sum=0;
       for(int i=0;i<(n+1)/2;i++)
       {
           sum=sum+arr[i];
       }
       return sum;
    }
    
    
}



