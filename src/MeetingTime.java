/**
* CS 111 Section No. 002
* Lab Assignment 3
* @author Samuel Harris 
**/

import java.util.Scanner;

public class MeetingTime {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int hours = 0, mins = 0;
		boolean valid = true;

		Clock myTime = new Clock(11, 0);

		System.out.println("Please enter your estimated time of arrival in military time.");
		System.out.println("Input your hours.");
		
		//Cycles until a valid number is given for the minutes and hours.
		while (valid) {
			try {

				hours = input.nextInt();

				if (hours < 0 || hours > 24) {
					throw new IllegalArgumentException("You entered invalid value of hours! Please enter again.");
				} else {
					valid = false;
				}

			} catch (IllegalArgumentException e) {
				System.out.println("Please re-enter the value of hours.");
			}
		}

		valid = true;
		
		System.out.println("Please enter your minutes.");

		while (valid) {
			try {
				mins = input.nextInt();
				
				//Numbers less than 0 and greater than 59 were restricted since there is no negative time and since 60 minutes is equal to one hour.
				if (mins < 0 || mins > 59) {
					throw new IllegalArgumentException("You entered invalid value of minutes! Please enter again.");
				} else {
					valid = false;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Please re-enter the value of minutes.");
			}
		}

		Clock friendTime = new Clock(hours, mins);

		System.out.println("Your estimated time of arrival is " + friendTime.toString());
		System.out.println();
		
		//Based on the output of the compareTo method a corresponding string will be printed out.
		if (myTime.compareTo(friendTime) == 0) {
			System.out.println("Looks like we will arrive at the same time.");
		} else if (myTime.compareTo(friendTime) == -1) {
			System.out.println("Looks like I will arrive before you.");
		} else if (myTime.compareTo(friendTime) == 1) {
			System.out.println("Looks like you will arrive before me.");
		}
	}
}
