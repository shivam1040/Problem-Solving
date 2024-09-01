/*
Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.

Example 1:

Input:
N = 4
Petrol = 4 6 7 4
Distance = 6 5 3 5
Output: 1
Explanation: There are 4 petrol pumps with
amount of petrol and distance to next
petrol pump value pairs as {4, 6}, {6, 5},
{7, 3} and {4, 5}. The first point from
where truck can make a circular tour is
2nd petrol pump. Output in this case is 1
(index of 2nd petrol pump).
Your Task:
Your task is to complete the function tour() which takes the required data as inputs and returns an integer denoting a point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity). If there exists multiple such starting points, then the function must return the first one out of those. (return -1 otherwise)

Expected Time Complexity: O(N)
Expected Auxiliary Space : O(1)

Constraints:
2 ≤ N ≤ 10000
1 ≤ petrol, distance ≤ 1000


*/

/*
Intuition
The idea is that instead of checking the whole array for each starting point, we can store the current tour inside a queue. At the moment, the current amount of petrol becomes inefficient (i.e., negative) to reach the next petrol pump, remove the current starting point from the queue and consider the next point as the new starting point. Instead of building a separate queue, we can use the array itself as a queue with the help of start and end pointers.

NOTE : Each petrol pump will be added in the queue at most twice and will be removed at most once.





1-2-3-4-5---gas-3-4-5-1-2---cost--2--2--2-3-3---gas-cost-difference--2--4--6--3-0---cumulative-sum-of-differences-0---total-sum-of-differences


Implementation
Set two pointers, start = 0 and end = 1 to use the array as a queue.
If the amount of petrol is efficient to reach the next petrol pump then increment the end pointer (circularly).
Otherwise, remove the starting point of the current tour, i.e., increment the start pointer.
If the start pointer reaches N then such a tour is not possible. Otherwise, return the starting point of the tour.

*/
//{ Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}
// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
        // Your code here	
        Queue<Pair> q=new LinkedList<>();
        int i=0, ans=-1, sz=0, curr=0, f=0, n=petrol.length;

        while(sz<n){
            q.add(new Pair(petrol[i] - distance[i], i));

            curr=curr+petrol[i]-distance[i];
            sz++;
            //indexing for circular traversal
            i=(i+1)%n;

            while(!q.isEmpty() && curr<0){
                curr=curr-q.peek().covered;
                sz--;
                //this means impossible to do circular traversing from any index
                if(q.peek().index==n-1){
                    f=1;
                    break;
                }
                q.poll();
            }
            if(f==1)
                break;
        }
        if(sz==n)
            ans=q.peek().index;
        return ans;
    }

    private static class Pair{
        int covered;
        int index;

        Pair(int covered, int index){
            this.covered=covered;
            this.index=index;
        }
    }
}
