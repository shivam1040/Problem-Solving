/*
There is a villa which has N rooms placed one after the other , numbered from 1 to N. There are two types of rooms - normal rooms and exit rooms.

The rooms are connected by K corridors, where ith corridor connects room Pair[i][0] and Pair[i][1]. And there are M exit rooms whose numbers are present in the array A. The rest of the rooms are normal rooms.

Rahul starts from room number 1 (only) to next room (room connected by a corridor), and so on . If it is a normal room he will keep on moving to other rooms but if he finds an exit room then he would reach out of the villa. Your task is to help Rahul in finding the last room which he can reach.

 

Example 1:

Input:
N = 5, M = 1, K = 2
A[] = {2}
Pairs = {(1 2), (2 4)}
Output:
2
Explanation:
There is only one exit room i.e. at room2.
So at beginning Rahul is at room1 as
always. As he performs 1st movement,
he would reach at room2. And now any
other movement will not affect the position
of Rahul. Hence Final position Room2.
 

Example 2:

Input:
N = 7, M = 3, K = 4
A[] = {3, 4, 6}
Pairs[] = {(1 2), (2 5), (5 7), (7 1)}
Output:
1
 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function lastRoom() which takes the array A[], its size M, vector pair vp[], its size K and an integer N as inputs and returns one integer denoting the room number outside which Rahul is standing.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)



Constraints:
2 ≤  N ≤ 1000
1  ≤  M ≤ N
1 ≤  K ≤ 1000
1  ≤  A[i]  ≤  N
1  ≤  pair[i].first , pair[i].second ≤ N
*/

/*
//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first=0, second=0;  
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
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(m)];
            pair vp[] = new pair[(int)(k)];
            
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a[i] = Long.parseLong(inputLine1[i]);
            }
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < 2*k; i+=2) {
                vp[i/2] = new pair(0,0);
                vp[i/2].first = Long.parseLong(inputLine[i]);
                vp[i/2].second = Long.parseLong(inputLine[i+1]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.lastRoom( a, vp, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


/*
class pair  {  
    long first=0, second=0;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Compute {
    public int lastRoom( long a[], pair vp[], long n, long m, long k) {
        // Your code goes here
        long ans=1, tmp=1, c=0, b=0;
        long arr[]=new long[(int)n+1];
        boolean chk=false;
        
        for(int i=0; i<m; i++)
            arr[(int)a[i]]=1;
        for(int i=0; i<k; i++){
            c=vp[i].first;
            b=vp[i].second;
        
            if(tmp==c){
                if(arr[(int)b]==1){
                    chk=true;
                    ans=b;
                    break;
                }
                else
                    tmp=b;
            }
            else if(tmp==b){
                if(arr[(int)c]==1){
                    chk=true;
                    ans=c;
                    break;
                }
                else
                    tmp=c;
            }
        }
        if(chk)
            return (int)ans;
        return (int)tmp;
    }
}
*/
