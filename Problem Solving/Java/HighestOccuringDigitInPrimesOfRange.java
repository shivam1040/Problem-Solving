/*
Given a range L to R, the task is to find the highest occurring digit in prime numbers which lie between L and R (both inclusive). If multiple digits have same highest frequency return the largest of them. If no prime number occurs between L and R, return -1.
 

Example 1:

Input: L = 2, R = 10
Output: 7
Explanation: Between 2 and 10 every digit
has same frquency and 7 is largest among
them.
Example 2:

Input: L = 2, R = 20
Output: 1
Explanation: Prime number between 2 and 20 are 
2, 3, 5, 7, 11, 13, 17, 19. 1 occur 
maximum i.e 5 times among 0 to 9.

Your Task:  
You dont need to read input or print anything. Complete the function maxDigit() which takes L and R as input parameter and returns the highest occuring digit. If multiple digits have same highest frequency return the largest of them. If no prime number occurs between L and R, return -1.

Expected Time Complexity: O(nlog(n)sqrt(n))
Expected Auxiliary Space: O(k)

Constraints:
1 <= L<= R <= 1000
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
            System.out.println(ob.maxDigit(L,R));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int maxDigit(int L, int R)
    {
        // code here
        int aux[]=new int[10];
        int freq=0;
        int res=-1;
        
        for(int i=L; i<=R; i++){
            if(isPrime(i)){
                count(i, aux);
            }
        }
        
        for(int i=0; i<aux.length; i++){
            if(aux[i]>freq){
                freq=aux[i];
                res=i;
            }
            else if(aux[i]==freq && aux[i]!=0){
                res=Math.max(i, res);
            }
        }
        
        return res;
        
    }
    
    boolean isPrime(int a){

        if(a<=1)

            return false;

        for(int i=2;i<a; i++)

        {

            if(a%i==0)

                return false;

        }

        return true;

    }
    
      void count(int num, int[] arr){

        while(num>0)

        {

            int rem = num%10;

            arr[rem] += 1;

            num/=10;

        }

    }
}
