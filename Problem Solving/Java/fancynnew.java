/*Instead of adding to or multiplying all the values, add to or multiply a transformation function, and apply that transformation only when a value is requested with getIndex.

Since we only add and multiply, the transformation is a linear function x ↦ ax + b, defined by a and b. When we add, we change it to (ax + b) + inc = ax + (b+inc), i.e., we just add inc to b. When we multiply, we change it to (ax + b) * m = (am)x + (bm), i.e., we multiply both a and b by m.

Then getIndex(i) applies the transformation, i.e., returns a * x[i] + b. But wait, if we just appended some value val and then immediately request it with getIndex, won't the transformation distort it? Yes, which is why we don't store val as-is. Instead we apply the inverse of the current transformation and store the result of that as x. Then whengetIndex applies the transformation, we get the correct val. In other words, when we shall append val, we store an x such that ax + b = val. That is, we store x = (val - b) * a**-1.*/
import java.util.*;
class Fancy1 {
    List<Long> append;
    long a;
    long b;
    public Fancy1() {
        append=new ArrayList<Long>();
        a=1;
        b=0;
    }
    
    public void append(int val) {
        Long x=(long) ((val-b+1000000007)%1000000007*inverse(a)%1000000007); //adding mod to val-b to ensure no negative number gets addes to list
        append.add(x);
       
    }
    
    public void addAll(int inc) {
         if(append.size()==0){
                return;
            }
        b=(b+inc)%1000000007; //doing mod everywhere to maintain result accuracy
    }
    
    public void multAll(int m) {
        a=(a*m)%1000000007;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        b=(b*m)%1000000007;
    }
    
    public Long getIndex(int idx) {
        if(append.size()==0 || idx>=append.size()){
            return Long.valueOf(-1);
        }
        return ((a*append.get(idx))%1000000007+b)%1000000007;
    }
    // https://cp-algorithms.com/algebra/module-inverse.html#:~:text=Practice%20Problems-,Definition,inverse%20does%20not%20always%20exist.
    // y^(MOD-2) === 1 mod MOD
    private long inverse(long y) {
        // y^e * a
        long e = 1000000007-2, aa = 1;
        while (e > 0) {
            if (e % 2 == 1) {
                aa = (aa * y)%1000000007;
            }
            e /= 2;
            y = (y * y)%1000000007;
        }
        return aa;
    }

    public static void main(String[] args) {
        //String arr[]={"Fancy","append","append","getIndex","append","getIndex","addAll","append","getIndex","getIndex","append","append","getIndex","append","getIndex","append","getIndex","append","getIndex","multAll","addAll","getIndex","append","addAll","getIndex","multAll","getIndex","multAll","addAll","addAll","append","multAll","append","append","append","multAll","getIndex","multAll","multAll","multAll","getIndex","addAll","append","multAll","addAll","addAll","multAll","addAll","addAll","append","append","getIndex"};
        //int arr1[]={0,12,8,1,12,0,12,8,2,2,4,13,4,12,6,11,1,10,2,3,1,6,14,5,6,12,3,12,15,6,7,8,13,15,15,10,9,12,12,9,9,9,9,4,8,11,15,9,1,4,10,9};
        String arr[]={"Fancy","append","addAll","append","multAll","getIndex","addAll","append","multAll","getIndex","getIndex","getIndex"};
        int arr1[]={0,2,3,7,2,0,3,10,2,0,1,2};
        Fancy1 obj=new Fancy1();
        for(int i=0; i<arr1.length; i++){
            if(arr[i]=="append"){
                obj.append(arr1[i]);

                System.out.print("null ,"); 
            }
            else if(arr[i]=="getIndex"){
                
                System.out.print(obj.getIndex(arr1[i])+", "); 
            }
            else if(arr[i]=="addAll"){
                obj.addAll(arr1[i]);
                System.out.print("null, "); 
            }
            else if(arr[i]=="multAll"){
                obj.multAll(arr1[i]);
                System.out.print("null, "); 
            }
        }
    }
}

