import java.util.*;
class Bracketresol{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t--!=0){
            String s=sc.nextLine();
            Stack<Character> st1=new Stack<Character>();
            boolean balance=true;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                    st1.push(s.charAt(i));
                    continue; //starts the loops from next iter without executing below
                }
               
                if(st1.isEmpty()){ //maKES sure the stack isn't empty before popping
                    balance=false;
                    break;
                }
                if(s.charAt(i)==')'){
                    if(st1.peek()=='('){
                        st1.pop();
                    }
                    else{
                        balance=false;
                        break;
                    }
                }
                if(s.charAt(i)==']'){
                    if(st1.peek()=='['){
                        st1.pop();
                    }
                    else{
                        balance=false;
                        break;
                    }
                }
                if(s.charAt(i)=='}'){
                    if(st1.peek()=='{'){
                        st1.pop();
                    }
                    else{
                        balance=false;
                        break;
                    }
                }
            }
            if(!st1.isEmpty()||!balance){
                System.out.println("unbalanced");
            }   
            else{
                System.out.println("balanced");
            }
        }
    sc.close();
    }

}