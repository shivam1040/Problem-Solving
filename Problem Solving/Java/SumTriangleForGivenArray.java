/*
Given a array, write a program to construct a triangle where last row contains elements of given array, every element of second last row contains sum of below two elements and so on.

Example 1:

Input:
A[] = {4, 7, 3, 6, 7};
Output:
81 40 41 21 19 22 11 10 9 13 4 7 3 6 7
Explanation:
       81
     40  41
   21  19  22
 11  10   9   13
4   7   3   6    7 
 

Example 2:

Input:
A[] = {5, 8, 1, 2, 4, 3, 14}
Output:
200 98 102 55 43 59 34 21 22 37 22
12 9 13 24 13 9 3 6 7 17 5 8 1 2 4 3 14 
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function getTriangle() which takes the array A[] and its size N as inputs and returns the sum triangle.

 

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

 

Constraints:
1<=N<=1000
1<=Ai<=1000
Elements in the triangle will not exceed 1018
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
            long Triangle[] = obj.getTriangle(a, n);
            int sz = Triangle.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(Triangle[i]+" ");
            System.out.println(output);
            
        }
	}
}



// } Driver Code Ends


//User function Template for Java

class Compute {
    
    public long[] getTriangle(long arr[], long n)
    {
           List<Long> aux=new ArrayList<>();

        for(long i:arr) {
            aux.add(i);
        }
        int i=aux.size()-1, j=aux.size()-2;
        int length=aux.size()-1, count=0;

        while(length>0){
            long a=aux.get(i);
            long b=aux.get(j);
            aux.add(0, a+b);
            count++;
            if(count==length){
                count=0;
                length--;
                i--;
                j--;
            }
        }
        return aux.stream().mapToLong(k -> k).toArray();
    }
}
