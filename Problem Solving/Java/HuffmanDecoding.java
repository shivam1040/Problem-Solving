/*
Given a encoded binary string and a Huffman MinHeap tree, your task is to complete the function decodeHuffmanData(), which decodes the binary encoded string and return the original string. 

Note: Each node of the min heap contains 2 data members, a character and an integer to denote its frequency. The character '$' is the special character used for internal nodes whose min heap node only need a integer field.


Example 1:

Input :
binaryString = 
0000000000001100101010101011111111010101010
Min Heap Tree =  
                $(20)
              /      \
            /          \
         $(8)            \
       /     \             \
    $(3)      \            $(12)
    /  \       \           /    \
B(1)    D(2)    E(5)    C(6)    A(6)

Output: AAAAAABCCCCCCDDEEEEE

Explanation:
The following chart can be made from the 
given min heap tree.
character    frequency    code
    A             6        00                 
    B             1        110
    C             6        01
    D             2        111    
    E             5        10

Example 2:

Input :
binaryString =
01110100011111000101101011101000111
Min Heap Tree =  
                         $(13)
                      /        \
                    /            \
                  /                \
               $(5)                  \
             /      \                  \
            /        \                   \
         $(3)         \                  $(8)
        /    \         \                /    \
     $(2)     \         \            $(4)     \
    /   \      \         \          /   \      \
f(1)    o(1)    r(1)    g(2)    k(2)    s(2)    e(4)

Output: geeksforgeeks

Explanation:
The following chart can be made from the 
given min heap tree.
character    frequency    code
    f             1        0000                 
    o             1        0001
    r             1        001
    g             2        01    
    k             2        100
    s             2        101
    e             4        11

Your Task:  
You dont need to read input or print anything. Complete the function decodeHuffmanData() which takes the root of the Huffman min heap tree and the encoded Binary String as input parameters and returns the decoded string.


Expected Time Complexity: O(N log N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 10^3
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class MinHeapNode
{
	char data;
	int freq;
	MinHeapNode left, right;
	MinHeapNode(char data, int freq)
	{
		left = right = null;
		this.data = data;
		this.freq = freq;
	}
}

// comparator class helps to compare the node 
// on the basis of one of its attribute. 
// Here we will be compared 
// on the basis of data values of the nodes. 
class MyComparator implements Comparator<MinHeapNode> { 
    public int compare(MinHeapNode x, MinHeapNode y) 
    { 
  
        return x.freq - y.freq; 
    } 
} 

class Driver_class
{
        static HashMap<Character, String> codes = new HashMap<>();
        static HashMap<Character, Integer> freq = new HashMap<>(); 
        
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            String encodedString = "", decodedString="";
            calcFreq(str, str.length());
            HuffmanCodes(str.length());
            for (int i = 0; i < str.length(); i++)
              encodedString += codes.get(str.charAt(i));
            //cout<<encodedString<<endl;
            decodedString = new Decode().decodeHuffmanData(minHeap.peek(), encodedString);
            System.out.println(decodedString);
        }
    }
    static void calcFreq(String str, int n)
    {
    	for (int i=0; i<str.length(); i++)
    	{
    	    char key = str.charAt(i);
    	    if(freq.containsKey(key) == true)
    	    {
    	        int fq = freq.get(key);
    	        freq.put(key, fq+1);
    	    }else freq.put(key, 1);
    	}	
    }
    
    // creating a priority queue q. 
        // makes a min-priority queue(min-heap). 
        static PriorityQueue<MinHeapNode> minHeap 
            = new PriorityQueue<MinHeapNode>(new MyComparator()); 
    
    static void HuffmanCodes(int size)
    {
    	 MinHeapNode left, right, top;
    // 	for (map<char, int>::iterator v=freq.begin(); v!=freq.end(); v++)
    // 		minHeap.push(new MinHeapNode(v->first, v->second));
         for(Map.Entry<Character, Integer> hm: freq.entrySet())
         {
             char ch = hm.getKey();
             int val = hm.getValue();
             minHeap.add(new MinHeapNode(ch, val));
         }
    	while (minHeap.size() != 1)
    	{
    		left = minHeap.peek();
    		minHeap.poll();
    		right = minHeap.peek();
    		minHeap.poll();
    		top = new MinHeapNode('$', left.freq + right.freq);
    		top.left = left;
    		top.right = right;
    		minHeap.add(top);
    	}
    	storeCodes(minHeap.peek(), "");
    }
    
    static void storeCodes(MinHeapNode root, String str)
    {
    	if (root==null)
    		return;
    	if (root.data != '$')
    		codes.put(root.data, str);
    	storeCodes(root.left, str + "0");
    	storeCodes(root.right, str + "1");
    }

}


// } Driver Code Ends


//User function Template for Java

/*class MinHeapNode
{
    char data;
    int freq;
    MinHeapNode left, right, top;
    MinHeapNode(char c, int freq)
    {
        left = right = null;
        this.data = c;
        this.freq = freq;
    }
}*/

class Decode
{
    //Function to return the decoded string.
    static String decodeHuffmanData(MinHeapNode root, String str)
    {
        
        // add your code here
         int n=str.length();     //length of the binary string

        String res= "";         //res variable to store result

        MinHeapNode curr=root;   //creating a curr node to traverse

        for(int i=0;i<n;i++){

            if(str.charAt(i)=='0'){

                curr=curr.left;

            }else if(str.charAt(i)=='1'){

                curr=curr.right;

            }

            if(curr.left==null && curr.right==null){

                res+=curr.data;

                curr=root;

            }

        }

        return res;

    }
}


