/*
Given a sorted array of positive integers. Your task is to rearrange the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.
Note: Modify the original array itself. Do it without using any extra space. You do not have to return anything.

Example 1:

Input:
n = 6
arr[] = {1,2,3,4,5,6}
Output: 6 1 5 2 4 3
Explanation: Max element = 6, min = 1, 
second max = 5, second min = 2, and 
so on... Modified array is : 6 1 5 2 4 3.
Example 2:

Input:
n = 11
arr[]={10,20,30,40,50,60,70,80,90,100,110}
Output:110 10 100 20 90 30 80 40 70 50 60
Explanation: Max element = 110, min = 10, 
second max = 100, second min = 20, and 
so on... Modified array is : 
110 10 100 20 90 30 80 40 70 50 60.
Your Task:
The task is to complete the function rearrange() which rearranges elements as explained above. Printing of the modified array will be handled by driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= n <= 10^6
1 <= arr[i] <= 10^7
*/

/*
Intuition
Idea is to use the logic  “Dividend = Divisor × Quotient + Remainder”. We will do arr[i] += arr[max_index] % max_element * max_element. [ max_element is bigger than all the array elements ] 
How does expression "arr[i] += arr[max_index] % max_element * max_element" work ? 
The purpose of this expression is to store two elements at index arr[i]. arr[max_index] is stored as multiplier and "arr[i]" is stored as remainder. For example in {1 2 3 4 5 6 7 8 9}, max_element is 10 and we store 91 at index 0. With 91, we can get the original element as 91%10 and the new element as 91/10.

Implementation
1. Initialize two pointers min_idx = 0 and max_idx = n – 1, where n is the size of the array.
2. Initialize an element mx equal to 1 + maximum element of the array.
3. Iterate over the array.
4. If current index is even , update a[i]=(a[i]+a[max_idx]%mx)*mx and decrement max_idx by 1.
5. Else if current index is odd , update a[i]=(a[i]+a[min_idx]%mx)*mx and increment min_idx by 1.
6. To update the array element back to its original form, divide a[i] by mx.

Example: Let's take arr=[1,2,3,4,5,6].

1. Here min_idx=0 and max_idx=5 and mx=6+1=7.
2. At i=0, i is even, so we have a[0]=a[0]+(a[5]%7)*7=43 and max_idx=4.
3. At i=1, i is odd, we have a[1]=a[1]+(a[0]%7)*7=9 and min_idx=1.
4. At i=2, i is even , we have a[2]=a[2]+(a[4]%7)*7=38 and max_idx=3.
5. At i=3, i is odd, we have a[3]=a[3]+(a[1]%7)*7=18 and min_idx=2.
6. At i=4, i is even, we have a[4]=a[4]+(a[3]%7)*7=33 and max_idx=3.
7. At i=5, is is odd , so we have a[5]=a[5]+(a[2]%7)*7=27 and min_idx=3.
8. So now the array is [43, 9, 38, 18, 33, 27].
9. We divide a[i] by mx for every i.
10. Now our array is [6, 1, 5, 2, 4 , 3].
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        
        // Your code here
        long m=arr[n-1]+1;
        boolean flag=true;
        int front=0, back=n-1;
        
        for(int i=0; i<n; i++){
            if(flag){
                long val=arr[back--]%m;
                arr[i]+=m*val;
            }
            else{
                long val=arr[front++]%m;
                arr[i]+=m*val;
            }
            flag=!flag;
        }
        for(int i=0; i<n; i++)
            arr[i]/=m;
    }
}

