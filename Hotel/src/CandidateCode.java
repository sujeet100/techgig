import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.*;

public class CandidateCode {

	private static class RoomSlot {
		public int start;
		public int end;
		public int diff;

		public RoomSlot(String start, String end) {
			if(start.contains("AM")){
				this.start = Integer.parseInt(start.replace("AM", ""));
			}else{
				this.start = Integer.parseInt(start.replace("PM", ""))+12;
			}

			if(end.contains("AM")){
				this.end = Integer.parseInt(end.replace("AM", ""));
			}else{
				this.end = Integer.parseInt(end.replace("PM", ""))+12;
			}
			this.diff = Math.abs(this.end - this.start);
		}
		
		@Override
		public String toString() {
			return this.start+"#"+this.end+"$"+this.diff;
		}

	}

	public static int profitValue(String[] roomSlots) {
		List<RoomSlot> slots = new ArrayList<RoomSlot>();
		boolean[] occupied = new boolean[24];
		for (int i = 0; i < roomSlots.length; i++) {

			CandidateCode.RoomSlot bridge = new CandidateCode.RoomSlot(
					roomSlots[i].split("#")[0],
					roomSlots[i].split("#")[1]);
			slots.add(bridge);

		}

		Collections.sort(slots, new Comparator<RoomSlot>() {

			@Override
			public int compare(RoomSlot o1, RoomSlot o2) {
				if (o1.diff < o2.diff) {
					return -1;
				}

				if (o1.diff == o2.diff)
					return 0;
				else
					return 1;
			}
		});

		List<RoomSlot> selectedRoomSlots = new ArrayList<CandidateCode.RoomSlot>();

		for (RoomSlot slot : slots) {
			boolean overlapped = false;
			
			for(int i=slot.start; i<slot.end ;i++){
				if(occupied[i])
					overlapped = true;
			}
			
			if(!overlapped){
				selectedRoomSlots.add(slot);
				for(int i=slot.start; i<slot.end ;i++){
					occupied[i]=true;
				}
			}
			
		}
		return selectedRoomSlots.size()*500;
	}
	
	public static void main(String[] args) {
		System.out.println(new CandidateCode().profitValue(new String[]{"6AM#8AM","11AM#1PM","7AM#3PM","7AM#10AM","10AM#12PM","2PM#4PM","1PM#4PM","8AM#9AM"}));
	}
}