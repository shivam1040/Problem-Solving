import java.util.ArrayList;
import java.util.List;

class Count{
    public static void main(String[] args) {
        String input=".aa....bb,,..cc.";
        
        int res=0;
        boolean check=false;
        for(int i=1; i<input.length(); i++){
            if(input.charAt(i)=='.' || input.charAt(i)==','){
                res++;
                check=true;
            }
            char w=input.charAt(i-1);
            if(check && Character.isLetter(w)){
                res++;
                check=false;
            }
            check=false;
        }
        if(input.charAt(0)=='.' || input.charAt(0)==',')
            res++;
        System.out.println(res);
    }
}