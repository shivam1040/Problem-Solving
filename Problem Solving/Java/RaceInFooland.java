/*
Fooland city has a special multi-lane running track. Lanes are numbered from 1 to Tracks. The lanes have N horizontal barriers lying on it (due to some digging and construction work). The ith barrier cover lanes from Li1 to Li2 (both inclusive). Also, the barriers may overlap. The athletes can’t run on the lanes on which barriers are present because they aren’t allowed to switch lanes anytime in the race. (Once a particular lane is allotted to an athlete he/she can’t switch his/her lane anytime during the race and there can be only one athlete on each lane.)

Now the race has to be organised tomorrow itself and the digging work could not be finished on time. The race would have to be organised on the same track only because Fooland city doesn’t have any other track. Help organizers in finding out how many athletes can run in a single race so that none of them would have to switch lanes.

 

Example 1:

Input:
N = 5, Track = 20
Li = {(1 3), (5 8), (8 13), 
           (14 15), (9 12)}

Output:
6

Explanation:
The barriers cover lanes from
 1 to 3, 5 to 8, 8 to 13, 
14 to 15 and 9 to 12. Hence, 
barriers are present on the 
lanes: {1, 2, 3, 5, 6, 7, 8,
 9, 10, 11, 12, 13, 14, 15}.

Hence, the lanes which doesn't
come under any barriers are 
{4, 16, 17, 18, 19, 20}.
So, there are 6 lanes on which
athletes can run – {4, 16, 17,
    18, 19, 20}
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function emptyLanes() which takes the pair array A[], its size N and an integer Tracks as inputs and returns the number of athletes that can run in a single track.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
1 ≤ Tracks ≤ 106
1 ≤ Li1 ≤ Li2 ≤ Tracks
The Barriers may overlap.
*/

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
            long tracks = Long.parseLong(stt.nextToken());
            pair a[] = new pair[(int)(n)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < 2*n; i+=2) {
                a[i/2] = new pair(0,0);
                a[i/2].first = Long.parseLong(inputLine[i]);
                a[i/2].second = Long.parseLong(inputLine[i+1]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.emptyLanes( a, n, tracks));
            
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

class Solution {
    public int emptyLanes( pair a[], long n, long tracks) {
        
        // Your code goes here
        boolean aux[]=new boolean[(int)tracks+1];
        int res=0;

        for(pair i:a){
            for(long j=i.first; j<=i.second; j++){
                aux[(int)j]=true;
            }
        }
        for(boolean i:aux)
            if(i==false)
                res++;
        return res-1;
    }
}
