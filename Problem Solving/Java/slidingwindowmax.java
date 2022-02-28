import java.util.*;
public class slidingwindowmax {
    public static void main(String[] args){
        int k=4;
        int a[]={};//{4, 3, 1, 2, 5, 3, 4, 7, 1, 9};
        Sol obj=new Sol();
        int ans[]=obj.slidiwi(a, k);
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
    static class Sol{
        public int[] slidiwi(int[] a, int k){
            int n=a.length;
            if(n==0){ //to make sure list isn't empty
                return a;
            }
            Deque<Integer> dq=new LinkedList<Integer>(); //making obj of deque using linkedlist
            int ans[]=new int[n-k+1];
            int i=0;
            for( ; i<k; i++){ //add k elements index in dq
            while(!dq.isEmpty() && a[dq.peekLast()]<=a[i]){ //checks if next inserted index in dq is small
                dq.removeLast();
            
        }
        dq.addLast(i);  
    }
    for( ; i<n; i++){ //iterates until n, stores index in ans starting from 0
        ans[i-k]=a[dq.peekFirst()];
        while(!dq.isEmpty() && dq.peekFirst()<=i-k){ //makes sure index outta window is removed
            dq.removeFirst();
        }
        while(!dq.isEmpty() && a[dq.peekLast()]<=a[i]){ //checks if next inserted index in dq is small
            dq.removeLast();
        
    }
    dq.addLast(i); 
    }
    ans[i-k]=a[dq.peekFirst()];
    return ans;
    }   
    }
}