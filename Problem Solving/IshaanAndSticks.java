/*
Ishaan has a craving for sticks. He has N sticks. He observes that some of his sticks are of the same length, and thus he can make squares out of those.
He wants to know how big a square he can make using those sticks as sides. Since the number of sticks is large, he can't do that manually. Can you tell him the maximum area of the biggest square that can be formed?
Also, calculate how many such squares can be made using the sticks.

 

Example 1:

â€‹Input : arr[ ] = {2, 2, 2, 9, 2, 2, 2, 2, 2}
Output : 4 2
Explanation:
2 squares of side 2 are formed.
return maximum area and number of square.

â€‹Example 2:

Input : arr[ ] = {5, 3, 2, 3, 6, 3, 3} 
Output :  9 1
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function square() that takes an array (arr), sizeOfArray (n) and return the array of the maximum area of the largest square that can be formed and the number of squares that can be formed if there is no possible square return -1. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(M), where M is the maximum value of an array.

 

Constraints : 
1 ≤ N ≤ 105
1 ≤ arri ≤ 103
*/

//{ Driver Code Starts
//Initial Template for Java

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
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.square(arr, sizeOfArray);
		    for(int i: ans)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static ArrayList<Integer> square (int arr[], int n) {
        //Complete the function
        Map<Integer, Integer> aux=new TreeMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        int max=0, side=0;
        
        for(int i:arr)
            aux.put(i, aux.getOrDefault(i, 0)+1);
        for (Map.Entry<Integer, Integer> entry : aux.entrySet()){
            if(entry.getValue()>=4){
            int area=entry.getKey();
                if(max<area*area){
                    max=area*area;
                    side=entry.getValue()/4;
                }
            }
        }
        if(max!=0){
        res.add(max);
        res.add(side);
        }
        else
            res.add(-1);
        return res;
    }
    
    
}



