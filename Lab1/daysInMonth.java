package week1;

import java.util.Scanner;

public class daysInMonth {
	
	//Get the month in number
	public static int inputMonth(String month) {
		if (month.equalsIgnoreCase("January") || month.equalsIgnoreCase("Jan.") || month.equalsIgnoreCase("Jan") || month.equals("1")) {
            return 1;
        } else if (month.equalsIgnoreCase("February") || month.equalsIgnoreCase("Feb.") || month.equalsIgnoreCase("Feb") || month.equals("2")) {
            return 2;
        } else if (month.equalsIgnoreCase("March") || month.equalsIgnoreCase("Mar.") || month.equalsIgnoreCase("Mar") || month.equals("3")) {
            return 3;
        } else if (month.equalsIgnoreCase("April") || month.equalsIgnoreCase("Apr.") || month.equalsIgnoreCase("Apr") || month.equals("4")) {
            return 4;
        } else if (month.equalsIgnoreCase("May") || month.equals("5")) {
            return 5;
        } else if (month.equalsIgnoreCase("June") || month.equals("6")) {
            return 6;
        } else if (month.equalsIgnoreCase("July") || month.equals("7")) {
            return 7;
        } else if (month.equalsIgnoreCase("August") || month.equalsIgnoreCase("Aug.") || month.equalsIgnoreCase("Aug") || month.equals("8")) {
            return 8;
        } else if (month.equalsIgnoreCase("September") || month.equalsIgnoreCase("Sept.") || month.equalsIgnoreCase("Sep") || month.equals("9")) {
            return 9;
        } else if (month.equalsIgnoreCase("October") || month.equalsIgnoreCase("Oct.") || month.equalsIgnoreCase("Oct") || month.equals("10")) {
            return 10;
        } else if (month.equalsIgnoreCase("November") || month.equalsIgnoreCase("Nov.") || month.equalsIgnoreCase("Nov") || month.equals("11")) {
            return 11;
        } else if (month.equalsIgnoreCase("December") || month.equalsIgnoreCase("Dec.") || month.equalsIgnoreCase("Dec") || month.equals("12")) {
            return 12;
        } else {
            return -1;
        }
	}
	
	public static int getDaysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
        	if((Math.floorMod(year, 4)==0 && Math.floorMod(year, 100)!=0) || Math.floorMod(year, 400)==0) {
    			return 29;
    		}
        	else return 28;
            
        } else {
            return -1; // Invalid month
        }
    }
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.printf("Enter the month: ");
		String month = scanner.nextLine();
		
		System.out.printf("Enter the year: ");
		int year= scanner.nextInt();
		
		System.out.printf("There are %d days in this month",getDaysInMonth(inputMonth(month),year));
		scanner.close();
	}
}
