/*
Given two unsorted arrays A of size N and B of size M of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.

 

Example 1:

Input:
A[] = {1, 2, 4, 5, 7}
B[] = {5, 6, 3, 4, 8} 
X = 9 
Output: 
1 8
4 5 
5 4
Explanation:
(1, 8), (4, 5), (5, 4) are the
pairs which sum to 9.
Example 2:
Input:
A[] = {-1, -2, 4, -6, 5, 7}
B[] = {6, 3, 4, 0} 
X = 8 
Output:
4 4 
5 3

Your Task:  
You don't need to read input or print anything. Your task is to complete the function allPairs() which takes the array A[], B[], its size N and M respectively and an integer X as inputs and returns the sorted vector pair values of all the pairs u,v where u belongs to array A and v belongs to array B. If no such pair exist return empty vector pair.
Note : All pairs should be printed in increasing order of u. For eg. for two pairs (u1,v1) and (u2,v2), if u1<u2 then
(u1,v1) should be printed first else second.


Expected Time Complexity: O(NLog(N))
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N, M ≤ 106
-106 ≤ X, A[i], B[i] ≤ 106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(stt.nextToken());
            long M = Long.parseLong(stt.nextToken());
            long X = Long.parseLong(stt.nextToken());
            long A[] = new long[(int)(N)];
            long B[] = new long[(int)(M)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            pair [] answer = obj.allPairs(A, B, N, M, X);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here 
        Map<Long, Long> aux=new HashMap<>();
        List<pair> res=new ArrayList<>();
        int count=0;
        
        for(long i:B)
            aux.put(i, aux.getOrDefault(i, 0L)+1);
        for(long i: A){
            long diff=X-i;
            if(aux.containsKey(diff) && aux.get(diff)>0){
                res.add(new pair(i, diff));
                aux.put(diff, aux.get(diff)-1);
            }
        }
        
        pair pair[]=new pair[res.size()];
        
        for(pair i:res)
            pair[count++]=i;
        Arrays.sort(pair, (o1 ,o2)-> (int) (o1.first - o2.first));
        return pair;
    }
}
