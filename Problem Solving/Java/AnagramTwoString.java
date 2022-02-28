/*
Find minimum number of changes required to make two halves of a string anagram
*/
public class AnagramTwoString {
	static int replacements(String s) {
		int digits[]=new int[10];
		String s1=s.substring(0, s.length()/2);
		String s2=s.substring(s.length()/2, s.length());
		for(int i=0, j=0; i<s.length()/2; i++,j++) {
			digits[s1.charAt(i)-'0']++;
			digits[s2.charAt(j)-'0']--;
		}
		int count=0;
		for(int i=0; i<digits.length; i++)
			if(digits[i]!=0)
				count+=Math.abs(digits[i]);
		return count/2;
	}
	
	public static void main(String args[]) {
		System.out.println(replacements("74512894613894651238684651978465128465132894415984615846513284651364198654875412684984797987979798984987"));
	}
}