/*
Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
Given an array, your task is to find the index of first Equilibrium point in the array.

Input Format:
The first line of input takes an integer T denoting the no of test cases, then T test cases follow. The first line of each test case is an integer N denoting The size of the array. Then in the next line are N space-separated values of the array. 

Output Format:
For each test case, the output will be the equilibrium index of the array. If no such index exists output will be -1.

User Task :
Your task is to complete the function (findEquilibrium) below which returns the index of the first Equilibrium point in the array. The function takes two arguments. The first argument is the array A[ ] and the second argument is the size of the array A.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1<=T<=100
1<=N<=105
-1000<=A[]<=1000

Example(To be used only for expected output):
Input
2
4
1 2 0 3
4
1 1 1 1

Output
2
-1
*/

/*
1) Initialize leftsum  as 0
2) Get the total sum of the array as sum
3) Iterate through the array and for each index i, do following.
    a)  Update sum to get the right sum.  
           sum = sum - arr[i] 
       // sum is now right sum
    b) If leftsum is equal to sum, then return current index. 
       // update leftsum for next iteration.
    c) leftsum = leftsum + arr[i]
4) return -1 
// If we come out of loop without returning then
// there is no equilibrium index
*/

//{ Driver Code Starts
import java.util.*;
class Index{
public static void main(String[] args)
 {
	 Scanner sc = new Scanner(System.in);
	 int T = sc.nextInt();
		while(T-- > 0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.findEquilibrium(a,n));
		}
}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
           public static int findEquilibrium(int arr[], int n)
              {
                //add code here.
                int sum=0, left=0, index=0;
                
                for(int i: arr) 
                    sum+=i;
                
                for(int i:arr){
                    sum-=i;
                    if(sum==left)
                        return index;
                    left+=i;
                    index++;
                }
                return -1;
              }
}
