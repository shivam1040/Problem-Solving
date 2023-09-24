/*
Sixy primes are prime numbers that differ from each other by six. For example, the numbers 5 and 11 are both sixy primes, because they differ by 6. Given a range of the form [L, R]. The task is to find all the sixy prime pairs in the range in increasing order.

Example 1:

Input: L = 11, R = 19
Output: [11, 17, 13, 19] 
Explanation: There are total two pair possible
with difference 6 and these are 11,17,13,19.  

Example 2:

Input: L = 6, R = 20
Output: [7, 13, 11, 17, 13, 19]
Explanation: There are total three pair possible
with difference 6 and these are 7,13,11,17,13,19. 

Your Task:  
You dont need to read input or print anything. Complete the function sixyPrime() which takes L and R as input parameter and returns all the sixy prime exist and if there are no sixy prime exist returns -1.

Expected Time Complexity: O(nloglogn)
Expected Auxiliary Space: O(n)

Constraints:
1 <= L <= R <=103
*/

//{ Driver Code Starts
//Initial Template for Java
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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int L = Integer.parseInt(input[0]); 
            int R = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            int[] ans = ob.sixyPrime(L,R);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] sixyPrime(int L, int R)
    {
        // code here
        List<Integer> res=new ArrayList<>();
        int i=L, j=L+1;
        
        while(j<=R && i<R){
            while(!isPrime(i))
                i++;
            while(!isPrime(j))
                j++;
            if(j-i==6 && i<R && j<=R){
                res.add(i);
                res.add(j);
                i++;
                j++;
            }
            else if(j-i<6)
                j++;
            else
                i++;
        }
        //System.out.println(res);
        if(res.isEmpty())
            res.add(-1);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;
 
        if (n == 2 || n == 3)
            return true;
 
        if (n % 2 == 0 || n % 3 == 0)
            return false;
 
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
 
        return true;
    }
}
