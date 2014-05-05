import java.io.*;
import java.util.*;

public class CandidateCode {
	public static int longestSeq(int[] array) {

		Vector<Integer> input = new Vector<Integer>();
		for (int i : array) {
			input.add(i);
		}
		Vector<Vector<Integer>> subs = new Vector<Vector<Integer>>();
		for(int i=0;i<array.length;i++){
			subs.add(new Vector<Integer>());
		}
		subs.get(0).add(input.get(0));
		int max = 0;
		for (int i = 1; i < input.size(); i++) {
			for (int j = i-1; j >= 0; j--) {
				if (input.get(i) > input.get(j) && subs.get(i).size() < subs.get(j).size()) {
					subs.get(i).removeAllElements();
					subs.get(i).addAll(subs.get(j));
				}
			}
			subs.get(i).add(input.get(i));
			if (max < subs.get(i).size())
				max = subs.get(i).size();
		}

		return max;

	}
	
	public static void main(String[] args) {
		System.out.println(new CandidateCode().longestSeq(new int[]{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}));
	}
}