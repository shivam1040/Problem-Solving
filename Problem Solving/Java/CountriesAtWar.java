/*
The two countries of A and B are at war against each other. Both countries have N number of soldiers. The power of these soldiers are given by A[i]...A[N] and B[i]....B[N].
These soldiers have a peculiarity. They can only attack their counterpart enemies, like A[i] can attack only B[i] and not anyone else. A soldier with higher power can kill the enemy soldier. If both soldiers have the same power, they both die. You need to find the winner country.

Example 1:

â€‹Input : a[ ] = {2, 2}, b[ ] = {5, 5}
Output : B
Explanation:
Both countries have 2 soldiers.
B[0] kills A[0], B[1] kills A[1]. 
A has 0 soldiers alive at the end. 
B has both soldiers alive at the end.
Return "B" as a winner.

â€‹Example 2:

Input : a[ ] = {9}, b[ ] = {8}  
Output :  A


Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function Country_at_war() that takes an array (a), another array (b), sizeOfArray (n), and return the string "A" if A is the winner, "B" if B is the winner and "DRAW" if it draws. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105
0 ≤ Ai ≤ 107
0 ≤ Bi ≤ 107
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
		     
		    int arr [] = new int[sizeOfArray];
		    int brr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    line = br.readLine();
		    String[] ele = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        brr[i] = Integer.parseInt(ele[i]);
		    }
		    Complete obj = new Complete();
		    String ans = obj.Country_at_war(arr, brr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}



// } Driver Code Ends


//User function Template for Java


class Complete{
    
   
    // Function for finding maximum and value pair
    public static String Country_at_war (int arr[], int brr[], int n) {
        //Complete the function
        int a=0, b=0;
        int countA=0, countB=0;
        
        for(int i=0; i<n; i++){
            a=arr[i];
            b=brr[i];
            if(a>b)
                countA++;
            else if(a<b)
                 countB++;
        }
        
        if(countA>countB)
            return "A";
        else if(countA<countB)
            return "B";
        return "DRAW";
        
    }
    
    
}



