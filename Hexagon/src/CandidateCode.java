import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;

public class CandidateCode {
	public static int goodHexa(int N, int L, int X, int K) {

		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		for (int i = L; i <= N; i++) {
			List<Integer> firstList = new ArrayList<Integer>();
			firstList.add(i);
			permutations.add(firstList);
		}

		for (int i = 1; i < 6; i++) {
			List<List<Integer>> newPermutations = new ArrayList<List<Integer>>();
			for (List<Integer> perm : permutations) {
				for (int j = 1; j <= X; j++) {
					if (Collections.frequency(perm, j)<K) {
						List<Integer> newList = new ArrayList<Integer>();
						newList.addAll(perm);
						newList.add(j);
						if (!containsSet(newPermutations, newList))
							newPermutations.add(newList);
					}
				}
			}
			permutations = newPermutations;
		}

		System.out.println(permutations);
		System.out.println(permutations.size());
		return permutations.size();

	}

	private static boolean containsSet(List<List<Integer>> newPermutations,
			List<Integer> destination) {
		for (List<Integer> list : newPermutations) {
			List<Integer> sortedList = new ArrayList<Integer>();
			sortedList.addAll(list);
			Collections.sort(sortedList);

			List<Integer> sortedDest = new ArrayList<Integer>();
			sortedDest.addAll(destination);
			Collections.sort(sortedDest);

			if (sortedList.equals(sortedDest))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		//System.out.println(new CandidateCode().goodHexa(10, 9, 5, 1));
		System.out.println(new CandidateCode().goodHexa(10,8,3,2));
	}
}