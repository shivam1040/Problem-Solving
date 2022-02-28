/*
Your assignment is to write a simple reconciliation program. The program must read sets of
records from two files (called X and Y further in the document), match these records and report
about discrepancies (also called breaks).
Records in both files have identical structure consisting of the following properties:
• Transaction ID – string that uniquely identifies a transaction record
• Account ID – string identifier of the account to which the transaction is posted
• Posting Date – date when the transaction was posted in the time zone of the processing
system
• Amount – amount of money posted, represented by number with 2 digit precision
Pair of records (x, y) is considered a match if the following criteria are met:
• Account ID is identical
• Posting Date absolute difference is no more than 1 working day (excluding weekends).
For example, difference between date falling on Friday and the one falling on the
following Saturday, Sunday or Monday is 1 day
• Amount absolute difference is no more than 1 “cent” (0.01)
If all of the three properties listed above are identical between records in a match, then such
match qualifies as exact, otherwise the match is called weak. Records between two sets (xs, ys)
are expected to match one to one. Records are ordered. If a record from xs matches more than
one record from ys, the first match is selected. A record from any side that matches no record
from the other side must be reported as break.

Data Samples
X set
x0; 000000001; 01-Jun-2016; 100.00
x1; 000000001; 01-Jun-2016; 100.00
x2; 000000002; 01-Jun-2016; 100.00
x3; 000000002; 01-Jun-2016; 100.00
x4; 000000003; 01-Jun-2016; 100.00
x5; 000000003; 02-Jun-2016; 100.00
x6; 000000004; 03-Jun-2016; 100.00
x7; 000000004; 06-Jun-2016; 100.00
Y set
y0; 000000001; 01-Jun-2016; 100.00
y0; 000000001; 01-Jun-2016; 100.00
y1; 000000001; 01-Jun-2016; 100.01
y2; 000000002; 02-Jun-2016; 100.00
y3; 000000002; 02-Jun-2016; 100.01
y4; 000000003; 02-Jun-2016; 101.00
y5; 000000003; 04-Jun-2016; 100.00
y6; 000000004; 06-Jun-20s16; 100.01
y7; 000000005; 06-Jun-2016; 100.00
Report
# XY exact matches
x0y0
# XY weak matches
x1y1, x2y2, x3y3, x6y6
# X breaks
x4, x5, x7
# Y breaks
y4, y5, y7
*/

package com.capgemini.assignment.Reconciliation;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Reconciliation {
	
	static void matcher(Map<String, String> exact, Map<String, String> weak, List<String> xBreak, List<String> yBreak, Scanner xObj, List<String> yInputs ) {
		while(xObj.hasNextLine()) {
			String x=xObj.nextLine().trim();
			if(!exact.containsKey(x) && !weak.containsKey(x)) {
				boolean check=true;
				if(yInputs.contains(x.substring(1, x.length()))) {
					exact.put(x, "y"+yInputs.get(yInputs.indexOf(x.substring(1, x.length()))));
					yInputs.remove(yInputs.indexOf(x.substring(1, x.length())));
					continue;
				}
				else if(check) {
				for(int i=0; i< yInputs.size(); i++) {
					if(yInputs.get(i).substring(0, yInputs.get(i).indexOf(";")).equals(x.substring(1, x.indexOf(";")))) {
						String y="y"+yInputs.get(i);
						if(weakMatcher(x, y)) {
							weak.put(x, y);
							yInputs.remove(i);
							check=false;
							break;
						}
					}
				}
				}
				if(check)
					xBreak.add(x);
			}
			}
			for(String i:yInputs)
				yBreak.add("y"+i);
			yInputs.clear();
			
		}
	
	static boolean weakMatcher(String x, String y) {
		try {
		String xAid=x.substring(x.indexOf(";")+1, x.indexOf(";", x.indexOf(";")+1));
		String yAid=y.substring(y.indexOf(";")+1, y.indexOf(";", y.indexOf(";")+1));
		String xDate=x.substring(x.indexOf(";", x.indexOf(";")+xAid.length()-1)+1, x.lastIndexOf(";")).trim();
		String yDate=y.substring(y.indexOf(";", y.indexOf(";")+yAid.length()-1)+1, y.lastIndexOf(";")).trim();
		double xAmt=Double.valueOf(x.substring(x.lastIndexOf(";")+1, x.length()).trim());
		double yAmt=Double.valueOf(y.substring(y.lastIndexOf(";")+1, y.length()).trim());
		double AmtDiff=Math.round(Math.abs(yAmt-xAmt)*100.0)/100.0;
		Date dateX=new SimpleDateFormat("dd-MMM-yyyy").parse(xDate);
		Date dateY=new SimpleDateFormat("dd-MMM-yyyy").parse(yDate);
	    long diff = TimeUnit.DAYS.convert(Math.abs(dateY.getTime() - dateX.getTime()), TimeUnit.MILLISECONDS);
	    Calendar c = Calendar.getInstance();
        c.setTime(dateX);
        String dayX = new SimpleDateFormat("EEEE").format(dateX);
        c.setTime(dateY);
        String dayY=new SimpleDateFormat("EEEE").format(dateY);
        if(xAid.equals(yAid) && (diff<=1 || (dayX.equals("Friday") && dayY.equals("Monday")) || (dayX.equals("Monday") && dayY.equals("Friday"))) && AmtDiff<=0.01)
        	return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String args[]) {
		File x = new File(".\\src\\main\\java\\com\\capgemini\\assignment\\Reconciliation\\Xset.txt");
		File y = new File(".\\src\\main\\java\\com\\capgemini\\assignment\\Reconciliation\\Yset.txt");
		Map<String, String> exact=new LinkedHashMap<String, String>();
		Map<String, String> weak=new LinkedHashMap<String, String>();
		List<String> xBreak=new ArrayList<String>(); 
		List<String> yBreak=new ArrayList<String>();
		List<String> yInputs=new ArrayList<String>();
		try {
			Scanner xObj=new Scanner(x);
			Scanner yObj=new Scanner(y);
			while(yObj.hasNextLine()) {
				String temp=yObj.nextLine();
				temp=temp.substring(1, temp.length()).trim();
				yInputs.add(temp);
			}
			matcher(exact, weak, xBreak, yBreak, xObj, yInputs);
			yObj.close();
			System.out.println("Report\n# XY exact matches");
			for (String i : exact.keySet()) {
				   System.out.print(i.substring(0, i.indexOf(";"))+""+exact.get(i).substring(0, exact.get(i).indexOf(";"))+", ");
				}
			System.out.println("\n# XY weak matches");
			for (String i : weak.keySet()) {
				   System.out.print(i.substring(0, i.indexOf(";"))+""+weak.get(i).substring(0, weak.get(i).indexOf(";"))+", ");
				}
			System.out.println("\n# X breaks");
			for(String i: xBreak)
				System.out.print(i.substring(0, i.indexOf(";"))+", ");
			System.out.println("\n# Y breaks");
			for(String i: yBreak)
				System.out.print(i.substring(0, i.indexOf(";"))+", ");	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}