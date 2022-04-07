/*
There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output: 
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
Example 2:

Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output: 
1
Explanation:
Only one meetings can be held
with given start and end timings.

Your Task :
You don't need to read inputs or print anything. Complete the function maxMeetings() that takes two arrays start[] and end[] along with their size N as input parameters and returns the maximum number of meetings that can be held in the meeting room.


Expected Time Complexity : O(N*LogN)
Expected Auxilliary Space : O(N)


Constraints:
1 ≤ N ≤ 105
0 ≤ start[i] < end[i] ≤ 105
*/

/*
Sort all pairs(Meetings) in increasing order of second number(Finish time) of each pair.
Select first meeting of sorted pair as the first Meeting in the room and push it into result vector and set a variable time_limit(say) with the second value(Finishing time) of the first selected meeting.
Iterate from the second pair to last pair of the array and if the value of the first element(Starting time of meeting) of the current pair is greater then previously selected pair finish time (time_limit) then select the current pair and update the result vector (push selected meeting number into vector) and variable time_limit.
Print the Order of meeting from vector.

basically when meeting list is sorted in ascending order of ending time then we are assured that first meeting ends at lowest possible time which is used for comparison when adding next meetings
*/

// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    import java.lang.*;
    
    class GFG {
        public static void main(String args[]) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
    
            while (t-- > 0) {
                String inputLine[] = br.readLine().trim().split(" ");
                int n = Integer.parseInt(inputLine[0]);
    
                int start[] = new int[n];
                int end[] = new int[n];
    
                inputLine = br.readLine().trim().split(" ");
                for (int i = 0; i < n; i++)
                    start[i] = Integer.parseInt(inputLine[i]);
    
                inputLine = br.readLine().trim().split(" ");
                for (int i = 0; i < n; i++) 
                    end[i] = Integer.parseInt(inputLine[i]);
                    
                int ans = new Solution().maxMeetings(start, end, n);
                System.out.println(ans);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution 
    {
        //Function to find the maximum number of meetings that can
        //be performed in a meeting room.
        public static int maxMeetings(int start[], int end[], int n)
        {
            List<Meeting> master=new ArrayList<Meeting>();
            for(int i=0; i<n; i++){
                master.add(new Meeting(start[i], end[i], i));
            }
            
            Collections.sort(master, new MyComparator());
            
            List<Integer> res=new ArrayList<Integer>();
            res.add(master.get(0).pos);
            
            int timeUpperLimit=master.get(0).end;
            
            for(int i=1; i<master.size(); i++){
                if(master.get(i).start>timeUpperLimit){
                    res.add(master.get(i).pos);
                    timeUpperLimit=master.get(i).end;
                }
            }
            
            return res.size();
        }   
        
    }
    
    class Meeting{
        int start, end, pos;
        
        Meeting(int start, int end, int pos){
            this.start=start;
            this.end=end;
            this.pos=pos;
        }
    }
    
    class MyComparator implements Comparator<Meeting>
    {
        @Override
        public int compare(Meeting o1, Meeting o2) 
        {
            if (o1.end < o2.end)
            {
                
                // Return -1 if second object is
                // bigger then first
                return -1;
            }
            else if (o1.end > o2.end)
            
                // Return 1 if second object is
                // smaller then first
                return 1;
                
            return 0;
        }
    }
    