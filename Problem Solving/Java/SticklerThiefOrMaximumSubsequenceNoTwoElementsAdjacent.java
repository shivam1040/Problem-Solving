// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    
    class GFG
     {
        public static void main (String[] args)
         {
          
          //taking input using Scanner class
          Scanner sc = new Scanner(System.in);
          
          //taking count of testcases
          int t = sc.nextInt();
          while(t-- > 0){
              
              //taking count of houses
              int n = sc.nextInt();
              int arr[] = new int[n];
              
              //inserting money present in 
              //each house in the array
              for(int i = 0; i<n; ++i)
                   arr[i] = sc.nextInt();
                
                //calling method FindMaxSum() of class solve
                System.out.println(new Solution().FindMaxSum(arr, n));
         }
       }
    }// } Driver Code Ends
    
    
    class Solution
    {
        //Function to find the maximum money the thief can get.
        public int FindMaxSum(int arr[], int n)
        {
            int dp[]=new int[n];
            Arrays.fill(dp, -1);
            return max(0, arr, dp);
        }
        
        //using top bottom approach
        
        //considering two cases one is including element, one is excluding element
        //at every point max of two above is checked to store that as answer in dp array at any given index
        private int max(int i, int arr[], int dp[]){
            if(i>=arr.length)
                return 0;
                
            if(dp[i]!=-1)
                return dp[i];
            
           
            int a=arr[i]+max(i+2, arr, dp);
             int b=max(i+1, arr, dp); //this case considers adding value after not considering current index element
            
            return dp[i]=Math.max(a, b); //this max considers that at every point both possibility of skipping and not skipping elements is calculated and max is inserted in dp at the calculated index for max optimum solution in terms of money in this case
        }
    }