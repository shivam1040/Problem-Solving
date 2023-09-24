/*
Given an array A[]of size N. Consider differences between first and last occurrences of all elements and find the maximum such difference.  Note that if any element appears only once, then the difference for the element is 0.
 

Example 1:

Input:
N = 9
A[] = {2, 1, 3, 4, 2, 1, 5, 1, 7}
Output:
6
Explanation:
For the above test case: Element 1,
index 1 and 7. Maximum difference 6.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function leftIndex() which takes the array A[] and its size N as inputs and returns the Maximum Difference.

 

Expected Time Complexity: O(N. Log(N))
Expected Auxiliary Space: O(N)

 

Constraints:
1<=N<=105
-105<=Ai<=105
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG{
	public static void main(String[] args) throws IOException{
		BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			int n = Integer.parseInt(br.readLine().trim());
			int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(inputLine[i]);
			
			Solution ob = new Solution();
			System.out.println(ob.maxDiffIndex(a, n));
		}
	}
	
}
// } Driver Code Ends


class Solution
{
	public int maxDiffIndex(int A[], int N)
	{
	    Map<Integer, ArrayList<Integer>> aux=new HashMap<>();
	    int res=0;
	    
	    for(int i=0; i<N; i++){
	        if(aux.containsKey(A[i])){
	            ArrayList<Integer> a=aux.get(A[i]);
	            a.add(1, i);
	            aux.put(A[i], a);
	        }
	        else{
	            ArrayList<Integer> a = new ArrayList<>();
	            a.add(i);
	            aux.put(A[i], a);
	        }
	    }
	    for (Map.Entry<Integer, ArrayList<Integer>> i : aux.entrySet())
	        if(i.getValue().size()>1 && i.getValue().get(1)-i.getValue().get(0)>res)
	            res=i.getValue().get(1)-i.getValue().get(0);
	   return res;
	}
}
