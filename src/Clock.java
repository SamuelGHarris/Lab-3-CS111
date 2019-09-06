/**
* CS 111 Section No. 002
* Lab Assignment 3
* @author Samuel Harris
**/

public class Clock implements Comparable{
	private int hours, mins;

	public Clock() {
		hours = 0;
		mins = 0;
	}

	public Clock(int hours_in, int mins_in) {
		hours = hours_in;
		mins = mins_in;

	}

	public int getHours() {
		return hours;
	}

	public int getMins() {
		return mins;
	}

	public String toString() {

		String dayTime = null;
		
		/*The int variables newHours and newMins are used to ensure the original variables for time, hours and mins, are not changed.
		Without this, logic errors will occur when trying to determine which time is earlier than the other.*/
		int newHours = hours, newMins = mins;
		
		//Ensures that the times are correctly labeled.
		if ((newHours == 24) || (newHours < 12)) {
			dayTime = "AM";
		} else if ((newHours >= 12) && (newHours != 24)) {
			dayTime = "PM";
		}
		
		//Used to convert to the 12-hour format.
		if (newHours >= 13) {
			newHours -= 12;
		} else if ((newHours < 1) && (newHours >= 0)) {
			newHours += 12;
		}

		//Necessary to correct the formatting problem that could happen when you enter a single digit minute value.
		if ((newMins >= 0) && (newMins <= 9)) {
			return (newHours + ":" + "0" + newMins + " " + dayTime);
		} else {
			return (newHours + ":" + newMins + " " + dayTime);
		}

	}

	public boolean equals(Object a) {
		
		boolean condition1 = a instanceof Clock;
		
		if (condition1) {
		Clock newA = (Clock) a;
		boolean condition2 = (this.hours == newA.hours) && (this.mins == newA.mins);
		return (condition1 && condition2);
		}
		return false;
	}

	public int compareTo(Object a) {
		
		int result;
		boolean condition1 = a instanceof Clock;
		Clock newA = (Clock) a;
		boolean condition2 = this.equals(newA);
		if (condition2) {
			result = 0;
		} else if (this.hours < newA.hours) {
			result = -1;
		} else if (this.hours > newA.hours) {
			result = 1;
		} else if ((this.hours == newA.hours) && (this.mins > newA.mins)) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}
}
