import java.util.Scanner;

public class Binary{
    public static void main(String args[]) {
        Scanner  scannerObj=new Scanner(System.in);
        System.out.print("Enter a number:");
        String binary=scannerObj.nextLine();
        boolean result=true;
        for(int i=0; i<binary.length()/2; i++){
            if(!(binary.charAt(i)>='0' && binary.charAt(i)<='1') || !(binary.charAt(binary.length()-1-i)>='0' && binary.charAt(binary.length()-1-i)<='1')){
                result=false;
                break;
            }
        }
        System.out.println(result);
    }
}