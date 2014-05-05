import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.*;

public class CandidateCode {

	private static class Bridge {
		public int citi1;
		public int citi2;
		public int diff;

		public Bridge(int citi1, int citi2) {
			this.citi1 = citi1;
			this.citi2 = citi2;
			this.diff = Math.abs(citi1 - citi2);
		}
		
		@Override
		public String toString() {
			return this.citi1+"#"+this.citi2+"$"+this.diff;
		}

	}

	public static int bridge(String[] bridges) {
		List<Bridge> br = new ArrayList<Bridge>();
		for (int i = 0; i < bridges.length; i++) {

			CandidateCode.Bridge bridge = new CandidateCode.Bridge(
					Integer.parseInt(bridges[i].split("#")[0]),
					Integer.parseInt(bridges[i].split("#")[1]));
			br.add(bridge);

		}

		Collections.sort(br, new Comparator<Bridge>() {

			@Override
			public int compare(Bridge o1, Bridge o2) {
				if (o1.diff < o2.diff) {
					return -1;
				}

				if (o1.diff == o2.diff)
					return 0;
				else
					return 1;
			}
		});

		List<Bridge> selectedBridges = new ArrayList<CandidateCode.Bridge>();

		for (Bridge bridge : br) {
			boolean intersected = false;
			
			for (Bridge selectedBridge : selectedBridges) {
				if ((bridge.citi1 - selectedBridge.citi1 < 0 && bridge.citi2
						- selectedBridge.citi2 > 0 || bridge.citi1 - selectedBridge.citi1 > 0 && bridge.citi2
								- selectedBridge.citi2 < 0)) {
					intersected = true;
				}
			}
			
			if(!intersected && selectedBridges.size()!=0)
			selectedBridges.add(bridge);
			
			if(selectedBridges.size() ==0)
				selectedBridges.add(bridge);
		}
		return selectedBridges.size();
	}
	
	public static void main(String[] args) {
		System.out.println(new CandidateCode().bridge(new String[]{"1#2", "2#4", "4#5","6#6", "3#3", "5#5"}));
	}
}