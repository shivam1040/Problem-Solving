/*
Given an array in such a way that the elements stored in array are in increasing order initially and then after reaching to a peak element , elements stored are in decreasing order. Find the highest element.
Note: A[i] != A[i+1]
 

Example 1:

Input:
11
1 2 3 4 5 6 5 4 3 2 1
Output: 6
Explanation: Highest element is 6.
Example 2:

Input:
5
1 2 3 4 5
Output: 5
Explanation: Highest element is 5.

 

Your Task:
You don't need to read or print anything. Your task is to complete the function findPeakElement() which takes the array as the input parameter and returns teh highest element.
 

Expected Time Complexity: O(log(n))
Expected Space Complexity: O(1)
 

Constraints:
2 <= Size of array <= 200
1 <= Elements of the array <= 100000 
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>(); 
            for( int i = 0; i < n; i++)
            {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);

        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int findPeakElement(List<Integer> a)
    {
        // Code here
        for(int i=1; i<a.size(); i++){
            if(a.get(i-1)>a.get(i))
                return a.get(i-1);
        }
        return a.get(a.size()-1);
    }
}
