/*
Given a list A having N positive elements. The task to create another list such as ith element is XOR of all elements of  A except A[i].

Example 1:

Input:
A = [2, 1, 5, 9]
Output:
13 14 10 6
Explanation:
At first position 1^5^9 = 13
At second position 2^5^9 = 14
At third position 2^1^9 = 10
At last position 2^1^5 = 6
Example 2:â€‹

Input:
A = [2, 1]
Output:
1 2
Explanation: 
At first position except first position 
there is only one element = 1
At second position except second position
â€‹there is only one element = 2
Your Task:  
You don't need to read input or print anything. Your task is to complete the function getXor() which takes a list A and an integer N which is the size of the list A and return the modified list.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1), Where N is the size of the input array

Constraints:
1<= N <=10000
1<= A[i] <=100000
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N = sc.nextInt();
            ArrayList<Integer> A = new ArrayList<>();
            for(int i=0;i<N;i++){
                A.add(sc.nextInt());
            }

            Solution ob = new Solution();
            ArrayList<Integer> B = ob.getXor(A,N);
            for(int i=0;i<N;i++){
                System.out.print(B.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> getXor(ArrayList<Integer> A,int N){
        // code here
        int allXor=0;
        
        for(int i:A)
            allXor^=i;
        
        for(int i=0; i<A.size(); i++)
            A.set(i, A.get(i)^allXor);
        
        return A;
    }
}
