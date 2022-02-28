import java.util.*;
public class ArrayKReverse {
    static int[] reverse(int arr[], int k){
        List<Integer> input=new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++){
            input.add(arr[i]);
        }

        int count=arr.length/k;
        String out="";
        int index=0;
        for(int i=1; i<=count; i++){
            for(int j=k; j<index; j--){
                out+=Integer.toString(arr[j])+",";
            }
        }



    }
}

// SELECT eid, ename, mid, mname FROM emp WHERE mnamae=ename 