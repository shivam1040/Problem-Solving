/*
You are given a series 1, 1, 2, 3, 5, 8,.... . Your task is to tell the position of Nth multiple of a number - A. Both A and Nth multiple are part of the given series. 

Example : 

Input : 
2
5
4
2
3

Output : 
30
8
Input : 
The first line of input contains an integer T denoting the Test cases. Then T test cases follow. 
The second line contains the skill value of N
The third line contains skill value of A

Output : 
Position of Nth multiple of A in the given series(indexing starting from 1)

Constraints :
1 ≤ T ≤ 50
1 ≤ N ≤ 10^8
1 ≤ A ≤ 10^8
*/

//{ Driver Code Starts
import java.util.*; 
import java.lang.*; 
class Find{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long test = sc.nextLong(); 
        while(test!=0)
        {
            long n,k;
            n = sc.nextLong();
            k = sc.nextLong();
            GFG g=new GFG();
            System.out.println(g.findPosition(n,k));
            test--; 
        }
         
    }
}

// } Driver Code Ends


class GFG
{
    public long findPosition(long N, long A)
    {
     // DO CODE.
     long x=1, y=1, i=2, t;
     
     while(y%A!=0){
         t=x+y;
         y=t;
         x=y;
         ++i;
     }
     return i*N;
    }
}
