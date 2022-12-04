/*
Given an array A[]  of n elements. Your task is to complete the Function num which returns an integer denoting the total number of times digit k appears in the whole array.

For Example:
Input:
A[]={11,12,13,14,15}, k=1
Output:
6

Explanation: Here digit 1 appers 
the whole array 6 times.
Your Task:

You don't need to read input or print anything. Complete the function Num() which accepts an integer N and array A as input parameter and return the desire output.

Constraints:
1<=T<=100
1<=n<=20
1<=A[]<=1000
*/

//{ Driver Code Starts
import java.util.*;
class Numbers{
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-->0)
	{
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		GfG g=new GfG();
		System.out.println(g.num(a,n,k));
	}
}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
          public static int num(int a[], int n, int k)
            {
                 //Your code here
                 int count=0;
                 
                 for(int i:a){
                     while(i>0){
                         int last=i%10;
                         if(last==k)
                            count++;
                         i=i/10;
                     }
                 }
                 return count;
            }
}
