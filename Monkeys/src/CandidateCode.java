import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateCode {
	public static int monkey(int[] input) {
		List<Integer> trees = new ArrayList<Integer>();
	
		for (Integer integer : input) {
			trees.add(integer);
		}
		
		int maxTime=0;
		for (int i=0;i<trees.size();i++) {
			int monkey1 = trees.get(i);
			for (int j=1;j<trees.size();j++) {
				int monkey2 = trees.get(j);
				int totalTime = monkey1+monkey2+Math.min(trees.size()-(j-i),j-i);
				if(maxTime<totalTime)
					maxTime = totalTime;
			}
		}
		return maxTime;
		
	}
	public static void main(String[] args) {
		System.out.println(new CandidateCode().monkey(new int[]{1,2,3,4}));
	}
}