/*
Geek has a ticket to the Geek Summer Carnival. The ticket has a positive integer B written on it. B denotes the base of a right-angled isosceles triangle. 
Geek can avail discounts on X courses in the carnival.

X is the maximum number of squares of size 2x2 units that can fit in the given right-angled isosceles triangle. 
Find X. 


Example 1:

Input:
B = 8
Output:
6 
Explanation: 


Example 2:

Input:
B = 2
Output:
0

Your Task:
You don't need to read input or print anything. Complete the function countSquare() that takes integer b as input parameter and returns the number of possible squares that can fit into the isosceles triangle. 


Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= B <= 1000
*/

/*
Since the triangle is isosceles, the given base would also be equal to the height. Here side of the square must be parallel to the base of the triangle.


Now in the diagonal part, we would always need an extra length of 2 units in both height and base of the triangle to accommodate a triangle. (The CF and AM segment of the triangle in the image. The part that does not contribute to any square). In the remaining length of base, we can construct (length / 2) squares. Since each square is of 2 units, same would be the case of height, there is no need to calculate that again. 

So, for each level of given length we can construct “(length-2)/2” squares. This gives us a base of “(length-2)” above it. Continuing this process to get the no of squares for all available “length-2” height, we can calculate the squares.

while length > 2
    answer += (length - 2 )/2
    length = length - 2
For more effective way, we can use the formula of sum of AP : n * ( n + 1 ) / 2, where n = length – 2
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int B = Integer.parseInt(br.readLine());
			Solution obj = new Solution();
			int count = obj.countSquare(B);
			System.out.println(count);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int countSquare(int B){
		//Write your code here
		int ans=0;
		
		while(B>2){
		    ans+=(B-2)/2;
		    B-=2;
		}
		
		return ans;
	}
}
