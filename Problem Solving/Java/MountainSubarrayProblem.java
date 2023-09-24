/*
We are given an array of integers and a range, we need to find whether the subarray which falls in this range has values in the form of a mountain or not. All values of the subarray are said to be in the form of a mountain if either all values are increasing or decreasing or first increasing and then decreasing. More formally a subarray [a1, a2, a3 … aN] is said to be in form of a mountain if there exists an integer K, 1 <= K <= N such that,
a1 <= a2 <= a3 .. <= aK >= a(K+1) >= a(K+2) …. >= aN
You have to process Q queries. In each query you are given two integer L and R, denoting starting and last index of the subarrays respectively.

Example 1:

Input:
N = 8
a[] = {2,3,2,4,4,6,3,2}
Q = 2
Queries = (0,2), (1,3)
Output:
Yes
No
Explanation: For L = 0 and R = 2, a0 = 2,
a1 = 3 and a2 = 2, since they are in the
valid order,answer is Yes.
For L = 1 and R = 3, a1 = 3, a2 = 2 and
a3 = 4, since a1 > a2 and a2 < a4 the
order isn't valid, hence the answer is
No.
Your Task:

Complete the function processQueries() which takes the array, size of array queries and number of queries as parameter. It should return a vector/ArrayList/array (depending upon language cpp/Java/Python) of boolean values, true if the subarray is in mountain form, false otherwise. The driver code will print "Yes" if the returned value is true, otherwise "No".

Expected Time Complexity: O(N + Q).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N, Q <= 105
1 <= a[i] <= 106, for each valid i
0 <= L <= R <= N-1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Pair {
    int l, r;
    Pair(int l, int r) {
        this.l = l;
        this.r = r;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            int q = Integer.parseInt(br.readLine().trim());
            ArrayList<Pair> queries = new ArrayList<Pair>();
            for (int i = 0; i < q; i++) {
                String[] lr = br.readLine().trim().split(" ");
                queries.add(
                    new Pair(Integer.parseInt(lr[0]), Integer.parseInt(lr[1])));
            }
            Solution sln = new Solution();

            ArrayList<Boolean> al = sln.processQueries(a, n, queries, q);
            for (boolean u : al) {
                if (u) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// refer Pair class in driver code
class Solution {
    public ArrayList<Boolean> processQueries(int[] a, int n, ArrayList<Pair> queries,
                                      int q) {
        // code here
        ArrayList<Boolean> res=new ArrayList<>();
        
        for(Pair j:queries){
            int l=j.l;
            int r=j.r;
            
            while(l<r && a[l]<=a[l+1])
                l++;
            while(l<r && a[l]>=a[l+1])
                l++;
            if(l<r)
                res.add(false);
            else
                res.add(true);
        }
        
        return res;
    }
}
