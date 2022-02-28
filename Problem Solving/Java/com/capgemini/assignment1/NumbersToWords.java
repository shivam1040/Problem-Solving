package com.capgemini.assignment1;

import java.util.Scanner;

class NumbersToWords {

    private static final String ZERO = "Zero";
    private static String[] oneToNine = {
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };

    private static String[] tenToNinteen = {
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static String[] dozens = {
            "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String solution(int number) {
        if(number == 0)
            return ZERO;
        String result=generate(number);
        result=result.replaceAll("  ", " ");
        result=result.trim();
        for(int i=result.length()-1; i>=0; i--) {
        	if(result.charAt(i)==' ') {
        		String temp=result.substring(result.lastIndexOf(" ", i-1), 1+result.lastIndexOf(" ", i+1));
        	if(temp.equals(" Hundred ") || temp.equals(" Thousand ") || temp.equals(" Million ") || temp.equals("Billion ")) {
        		result=result.substring(0, i)+" and"+result.substring(i, result.length());
        		break;
        	}
        	}
        }
        return result;
    }

    public static String generate(int number) {
        if(number >= 1000000000) {
            return generate(number / 1000000000) + " Billion " + generate(number % 1000000000);
        }
        else if(number >= 1000000) {
            return generate(number / 1000000) + " Million " + generate(number % 1000000);
        }
        else if(number >= 1000) {
            return generate(number / 1000) + " Thousand " + generate(number % 1000);
        }
        else if(number >= 100) {
            return generate(number / 100) + " Hundred " + generate(number % 100);
        }

        return generate1To99(number);
    }

    private static String generate1To99(int number) {
        if (number == 0)
            return "";

        if (number <= 9)
            return oneToNine[number - 1];
        else if (number <= 19)
            return tenToNinteen[number % 10];
        else {
            return dozens[number / 10 - 1] + " " + generate1To99(number % 10);
        }
    }
    
    public static void main(String args[]) {
    	Scanner userInput=new Scanner(System.in);
    	System.out.print("Enter the number: ");
    	System.out.println(solution(userInput.nextInt()));
    	userInput.close();
    }
}