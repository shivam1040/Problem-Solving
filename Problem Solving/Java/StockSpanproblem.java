/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stocks price for all n days. 
The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Example 1:

Input: 
N = 7, price[] = [100 80 60 70 60 75 85]
Output:
1 1 1 2 1 4 6
Explanation:
Traversing the given input span 
100 is greater than equal to 100 and there are no more elements behind it so the span is 1,
80 is greater than equal to 80 and smaller than 100 so the span is 1,
60 is greater than equal to 60 and smaller than 80 so the span is 1,
70 is greater than equal to 60,70 and smaller than 80 so the span is 2,
60 is greater than equal to 60 and smaller than 70 so the span is 1,
75 is greater than equal to 60,70,60,75 and smaller than 100 so the span is 4,
85 is greater than equal to 80,60,70,60,75,85 and smaller than 100 so the span is 6. 
Hence the output will be 1 1 1 2 1 4 6.
Example 2:

Input: 
N = 6, price[] = [10 4 5 90 120 80]
Output:
1 1 2 4 5 1
Explanation:
Traversing the given input span 
10 is greater than equal to 10 and there are no more elements behind it so the span is 1,
4 is greater than equal to 4 and smaller than 10 so the span is 1,
5 is greater than equal to 4,5 and smaller than 10 so the span is 2,
90 is greater than equal to all previous elements so the span is 4,
120 is greater than equal to all previous elements so the span is 5,
80 is greater than equal to 80 and smaller than 120 so the span is 1,
Hence the output will be 1 1 2 4 5 1.

User Task:
The task is to complete the function calculateSpan() which takes two parameters, an array price[] denoting the price of stocks, and an integer N denoting the size of the array and number of days. This function finds the span of stock's price for all N days and returns an array of length N denoting the span for the i-th day.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105
1 ≤ C[i] ≤ 105


*/

/*
The idea is that S[i] on the day i can be easily computed if we know the closest day preceding i, such that the price is greater than on that day than the price on the day i. If such a day exists, let’s call it h(i), otherwise, we define h(i) = -1

Implementation
Declare empty stack s and vector<int> S of size n.
Push 0 into stack s and initialize S[0] as 1, pushing index 0 into stack and for index 0, S[0] = 1.
Run a loop for i from 1 to n-1:
We pop elements from the stack s till price at top of stack is less than or equal to current price.
If stack s  becomes empty, then price[i] is greater than all elements on left of it in list so span is i+1.
Else price[i] is greater than elements after value at top of stack s so span will be (i - s.top()).
Initialize S[i] with span calculated for current index i.
Push index i into stack s.
Return vector S as answer.
Example :

Input: n = 4, price = {10, 4, 5, 90}

 

For i=0: s = {}, here S[0] = 1 as only {10} is less than or equal to 10 and there is no element in left to it.

For i=1: s = {1}, here S[1] = 1 as only {4} <= 4, as in left of it there is 10(having index 0) which is greater than 4.

For i=2: s = {1, 1}, here S[2] = 2 as {4, 5} are <= 5, and in more left of it there is 10(having index 0) which is greater

         than 5.

For i=3: s = {1, 1, 2}, here S[3] = 4 as {10, 4, 5, 90} are <= 90, and s is empty so it means all elements in left of 90 

         are less than or equal to 90.

Return S = {1, 1, 2, 4} as answer.
*/

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        int[] aux=new int[n];
        Stack<Integer> aux1=new Stack<>();
        aux[0]=1;
        
        aux1.push(0);
        for(int i=1; i<n; i++){
            while(!aux1.isEmpty() && price[i]>=price[aux1.peek()])
                aux1.pop();
            aux[i]=aux1.isEmpty() ? i+1 : i-aux1.peek();
            
            aux1.push(i);
        }
        return aux;
    }
}

//{ Driver Code Starts.

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for (i = 0; i < n; i++) a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for (i = 0; i < n; i++) {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
    }
}
// } Driver Code Ends
