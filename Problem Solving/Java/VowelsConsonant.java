import java.util.Scanner;

import javax.swing.text.StyledEditorKit;

public class VowelsConsonant {
    public static void main(String args[]){
        Scanner scannerObj=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String input=scannerObj.nextLine();
        int vowel=0;
        int consonant=0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)>'9'){
                if(input.charAt(i)=='a' || input.charAt(i)=='e' || input.charAt(i)=='i' || input.charAt(i)=='o' || input.charAt(i)=='u')
                    vowel++;
                else
                    consonant++;
            }
        }
        System.out.println("vowel :"+vowel+"\nconsonant: "+consonant);
    }
}
