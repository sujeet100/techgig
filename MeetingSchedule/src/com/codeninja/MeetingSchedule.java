package com.codeninja;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MeetingSchedule {

	private static final int No_OF_MINUTES_IN_A_SLOT = 2;
	private static final int NO_OF_SLOTS = 24 * (60/No_OF_MINUTES_IN_A_SLOT) - 1;
	//Every slot represents 15 mins
	static boolean[] meetingSlots = new boolean[NO_OF_SLOTS];
	static int meetingDuration;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String firstRow = in.readLine();
		m = Integer.parseInt(firstRow.split(" ")[0]);
		meetingDuration = Integer.parseInt(firstRow.split(" ")[1]);

		for (int row = 0; row < m; row++) {
			String line = in.readLine();
			String[] splitString = line.split(" ");
		
			int startTimeHours = Integer.parseInt(splitString[0]);
			int startTimeMinutes = Integer.parseInt(splitString[1]);
			int endTimeHours = Integer.parseInt(splitString[2]);
			int endTimeMinutes = Integer.parseInt(splitString[3]);
			
			for (int i = getSlot(startTimeHours, startTimeMinutes); i < getSlot(endTimeHours, endTimeMinutes); i++) {
				meetingSlots[i] = true;

			}
		}

		int noOfSlotsToBeOccupied = meetingDuration / No_OF_MINUTES_IN_A_SLOT;
		
		int slotStart=0;
		while(slotStart<NO_OF_SLOTS) {

			if (!meetingSlots[slotStart]) {
				int slotEnd = slotStart;
				while (slotEnd< NO_OF_SLOTS && !meetingSlots[slotEnd])
					slotEnd++;

				if (slotEnd - slotStart >= noOfSlotsToBeOccupied) {
					System.out.println(getSlotTime(slotStart) + " "+ getSlotTime(slotEnd));
				}
				slotStart = slotEnd;
			}else{
				slotStart++;
			}
		}
	}

	private static int getSlot(int hour, int minutes) {
		return hour * 60/No_OF_MINUTES_IN_A_SLOT + (minutes / No_OF_MINUTES_IN_A_SLOT);
	}
	
	private static String getSlotTime(int slotIndex){
		if(slotIndex == NO_OF_SLOTS){
			return "00 00";
		}
		int slotHour = slotIndex *No_OF_MINUTES_IN_A_SLOT / 60;
		int slotMinutes = slotIndex * No_OF_MINUTES_IN_A_SLOT % 60;
		return getDigitsAsString(slotHour)+" "+getDigitsAsString(slotMinutes);
	}
	
	private static String getDigitsAsString(int digits){
		if(digits <= 9){
			return "0"+digits;
		}else{
			return Integer.toString(digits);
		}
	}
}
