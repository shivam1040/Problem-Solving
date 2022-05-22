/*
Given an array A of N integers, find any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k.

Example 1:

Input:
N = 5
A[] = {1,2,1,1,3}
Output: 1
Explanation: a sub-sequence 1 2 3 exist.
Example 2:

Input:
N = 3
A[] = {1,1,3}
Output: 0
Explanation: no such sub-sequence exist.
Your Task:
Your task is to complete the function find3Numbers which finds any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k. You need to return them as a vector/ArrayList/array (depending on the language cpp/Java/Python), if no such element is present then return the empty vector of size 0.

Note: The output will be 1 if the sub-sequence returned by the function is present in array A else 0. If the sub-sequence returned by the function is not in the format as mentioned then the output will be -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
1 <= A[i] <= 106, for each valid i
*/
// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    class SubSeq {
        public static boolean isSubSequence(ArrayList<Integer> v1, ArrayList<Integer> v2,
                                     int n, int m) {
    
            if (m == 0) return true;
            if (n == 0) return false;
    
            if (v1.get(n - 1).equals(v2.get(m - 1)))
                return isSubSequence(v1, v2, n - 1, m - 1);
    
            return isSubSequence(v1, v2, n - 1, m);
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int tc = Integer.parseInt(br.readLine().trim());
            while (tc-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                String[] str = br.readLine().trim().split(" ");
                ArrayList<Integer> a = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    a.add(Integer.parseInt(str[i]));
                }
                Solution g = new Solution();
                ArrayList<Integer> res = g.find3Numbers(a, n);
    
                // wrong format output
                if (!res.isEmpty() && res.size() != 3) {
                    System.out.println(-1);
                }
    
                if (res.isEmpty()) {
                    System.out.println(0);
                } else if ((res.get(0) < res.get(1)) && (res.get(1) < res.get(2)) &&
                           isSubSequence(a, res, n, res.size())) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the function below*/
    
    class Solution {
        ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
           int a=Integer.MAX_VALUE, b=Integer.MIN_VALUE, c=0;
           int a_index=-1, b_index=-1, c_index=-1;
           for(int i=0; i<n; i++){
               if(arr.get(i)<a){
                a=arr.get(i);
                a_index=i;
                continue;
               }
               if(arr.get(i)==a)
                continue;
               if(i>a_index && arr.get(i)>a){
                   b=arr.get(i);
                   b_index=i;
               }
               int j=i+1;
               while(j<n){
                   if(arr.get(j)>b){
                       
                    c=arr.get(j);
                    c_index=j;
                    //System.out.println(c);
                    break;
                   }
                   j++;
               }
               if(c_index>-1)
                break;
           }
           ArrayList<Integer> res=new ArrayList<Integer>();
           //System.out.println(a_index+" "+b_index+" "+c_index);
           if(a_index>-1 && b_index>-1 && c_index>-1){
            res.add(a);
            res.add(b);
            res.add(c);
            
           }
           //System.out.println(res);
           return res;
        }
    }
    