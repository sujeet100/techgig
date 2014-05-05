import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CandidateCode {
	public static String partition(int[] array) {

		List<Integer> list1 = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if(array[i]<=0)
				return "Invalid";
			list1.add(array[i]);
		}
		int sum = getSum(list1);

		List<Integer> list2 = new ArrayList<Integer>();

		if(sum%2!=0)
			return "No";
		Integer max=Collections.max(list1);
		list1.remove(max);
		list2.add(max);
		
		if(getSum(list1)==getSum(list2))
			return "Yes";
		
		for(int i=0;i<1000;i++){
			int sum1 = getSum(list1);
			int sum2 = getSum(list2);
			if(sum1==sum2){
				return "Yes";
			}else if(sum1<sum2){
				Integer closetElement = getClosestElement(list2, sum2-sum1);
				list2.remove(closetElement);
				list1.add(closetElement);
			}else{
				Integer closetElement = getClosestElement(list1, sum1-sum2);
				list1.remove(closetElement);
				list2.add(closetElement);
			}
		}
		return "No";
		
		
	}

	private static int getClosestElement(List<Integer> list2, int diff) {
		int closest = 0;
		for (Integer integer : list2) {
			
			if(closest<Math.abs(integer-diff/2)){
				closest = integer;
			}
		}
		return closest;
	}

	private static int getSum(List<Integer> list1) {
		int sum=0;
		for (int i = 0; i < list1.size(); i++) {
			sum=sum+list1.size();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(new CandidateCode().partition(new int[]{1,5,11,5}));
	}
}