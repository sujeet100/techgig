import java.io.*;
import java.util.Collections;
import java.util.Stack;

public class CandidateCode {
	static int count=0;
	static int start;
	static Stack<Integer> stack = new Stack<Integer>();
	public static int get_order(int[] disks) {
		
		for (int j=disks.length-1; j>=0; j--) {
			stack.push(disks[j]);
		}
		
		start =0;
		while(start<stack.size()-1)
		sort(disks);
		
		return count;
		
	}

	private static void sort(int[] disks) {
		
		
		int maxIndex =start;
		for(int k=stack.size()-1; k>=start;k--)
			maxIndex = stack.get(maxIndex)<stack.get(k)?k:maxIndex;
		
		
		if(maxIndex != 0){
			int nextMaxIndex=maxIndex-1;
			for(int i=maxIndex-1;i>=start;i--){
				 nextMaxIndex = stack.get(nextMaxIndex)<stack.get(i)?i:nextMaxIndex;
			}
			Integer removed = stack.remove(nextMaxIndex);
			stack.push(removed);
			count++;
		}
		maxIndex =start;
		for(int k=stack.size()-1; k>=start;k--)
			maxIndex = stack.get(maxIndex)<stack.get(k)?k:maxIndex;
		if(maxIndex == start){
			start++;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new CandidateCode().get_order(new int[]{1,3,2}));
	}
}