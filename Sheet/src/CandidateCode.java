import java.io.*;
import java.util.*;

public class CandidateCode {
	public static int[] sheetWay(int K) {
		Map<Integer, Integer> factors = new HashMap<Integer, Integer>();
		if(K==1){
			factors.put(0, 1);
		}
		for (int i = 1; i <= K / 2; i++) {
			if (K % i == 0) {
				factors.put(Math.abs(K / i - i), i);
			}
		}

		int a = factors.get(Collections.min(factors.keySet()));
		int b = K / a;
		int[] output = new int[2];
		output[0] = (a + b) / 2;
		output[1] = (a - b) / 2;
		return output;
	}
	public static void main(String[] args) {
		System.out.println(new CandidateCode().sheetWay(11));
	}
}