class Solutiony {
    public String nearestPalindromic(String n) {
        long s=0;
        long b=0;
        long m=Long.parseLong(n);
        String res="";
            for(long i=m-1; i>=0; i--){
                String ini=String.valueOf(i);
                String temp1=new StringBuilder(ini).reverse().toString();
                if(ini.equals(temp1)){
                    s=Long.parseLong(temp1);
                    break;
                }
                
        }
        for(long i=m+1; i>m; i++){
            String ini=String.valueOf(i);
                String temp1=new StringBuilder(ini).reverse().toString();
                if(ini.equals(temp1)){
                    b=Long.parseLong(temp1);
                    break;
                }
        
    }
    long finals=m-s;
    long finalb=b-m;
    if(finals<finalb){
        res=String.valueOf(s);
        return res;
    }
    else{
        if(finals==finalb){
            return String.valueOf(s);
        }
        res=String.valueOf(b);
        return res;
    }
}

public static void main(String[] args) {
    Solutiony obj=new Solutiony();
    System.out.println(obj.nearestPalindromic("807045053224792883"));
}

}
