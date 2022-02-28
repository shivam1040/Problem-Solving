/*
finding palindrome for all the range of numbers
*/
class Compariso {
    static int compare(int n){
        int temp=n;
        int tem1=0;
        while(n>0){
            int rem=n%10;
            temp1+=(rem*10)+n;
            n=n/10;
        }
        if(temp<0){
            temp1*=-1;
            return temp1;
        }
        return temp1;
    }
}
    public static void main(String[] args) {
        System.out.println(compare(321));
    }




