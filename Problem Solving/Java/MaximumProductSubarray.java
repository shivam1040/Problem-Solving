/*
Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is [6, -3, -10] which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is [2, 3, 4, 5] which gives product as 120.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.
Note: Use 64-bit integer data type to avoid overflow.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 500
-102 ≤ Arri ≤ 102


*/

/*
Intuition
The intuition is to maintains two variable, maxVal and minVal, to track the maximum and minimum product of subarrays ending at the current index. It traverses through the array and updates these variables based on the current element's value. The goal is to handle negative numbers by swapping maxVal and minVal when encountering a negative element to ensure that the maximum product is accurately calculated.

Implementation
Initialize minVal, maxVal, and maxProduct with the value of the first element of the array.
Start iterating through the array from the second element (index 1) up to the last element.
Inside the loop:
If the current element is negative, swap maxVal and minVal. This swap handles negative numbers to ensure that maxVal holds the maximum product and minVal holds the minimum product of subarrays ending at the current index.
Update maxVal and minVal by taking the maximum and minimum between the current element and the product of the current element with the respective values (maxVal and minVal) from the previous index.
Update maxProduct by taking the maximum between maxProduct and maxVal.
After the loop completes, return maxProduct, which holds the maximum product of a subarray within the given array.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        // long maxP=arr[0], maxN=arr[0], res=arr[0];
        
        // for(int i=1; i<n; i++){
        //     if(arr[i]<0){
        //         long temp=maxP;
        //         maxP=maxN;
        //         maxN=temp;
        //     }
        //     maxP=Math.max(arr[i], maxP*arr[i]);
        //     maxN=Math.max(arr[i], maxN*arr[i]);
        //     res=Math.max(res, maxP);
        // }
            
        // return res;
                long minVal = arr[0];
        long maxVal = arr[0];

        long maxProduct = arr[0];

        for (int i = 1; i < n; i++) {

            // When multiplied by -ve number,
            // maxVal becomes minVal
            // and minVal becomes maxVal.
            if (arr[i] < 0) {
                long temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }

            // maxVal and minVal stores the
            // product of subarray ending at arr[i].
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            // Max Product of array.
            maxProduct = Math.max(maxProduct, maxVal);
        }

        // Return maximum product found in array.
        return maxProduct;
    }
}
