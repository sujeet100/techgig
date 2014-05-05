import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CandidateCode {
	
	static int count=0;
	public static int correctResult(int N, int[] prefix) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			boolean contains = false;
			for (int j = 0; j < prefix.length; j++) {
				if (i == prefix[j])
					contains = true;
			}
			if (!contains)
				numbers.add(i);
		}

		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		List<Integer> firstList = new ArrayList<Integer>();
		for (Integer integer : prefix) {
			firstList.add(integer);
		}
		permutations.add(firstList);
		for (int i = 0; i < numbers.size(); i++) {
			List<List<Integer>> newPermutations = new ArrayList<List<Integer>>();
			for (List<Integer> perm : permutations) {
				for (int number : numbers) {
					if (!perm.contains(number)) {
						List<Integer> newList = new ArrayList<Integer>();
						newList.addAll(perm);
						newList.add(number);
						newPermutations.add(newList);
					}
				}
			}
			permutations = newPermutations;
		}

		for (List<Integer> perm : permutations) {
			int expectedOutput = getExpectedOutput(perm);
	//		System.out.print("\n"+perm+" E: "+expectedOutput);
			int rohansOutput = getRohansOutput(perm);
		//	System.out.print(" R: "+rohansOutput);
			if(expectedOutput == rohansOutput){
				count++;
			}
		}

		return count==0?-1:count;

	}

	private static int getRohansOutput(List<Integer> perm) {
		int diff = 0;
		for (int i=0; i<perm.size();i++) {
			diff =diff + Math.max(i+1-perm.get(i), 0);
		}
		return diff;
	}

	private static int getExpectedOutput(List<Integer> perm) {

		int inv_count = 0;
		  int i, j;
		 
		  for(i = 0; i < perm.size()-1; i++)
		    for(j = i+1; j < perm.size(); j++)
		      if(perm.get(i) > perm.get(j))
		        inv_count++;
		 
		  return inv_count;

	}

	public static void main(String[] args) {
		System.out.println("\nANS: "+new CandidateCode().correctResult(5, new int[] {1,4}));
	}
}