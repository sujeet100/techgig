import java.io.*;

public class CandidateCode {
	public static int getWinner(int n, int l) {
		boolean array[] = new boolean[n];
		int eliminated = 0;
		int current = -1;
		while (eliminated != n - 1) {
			int time = l;
			while (time > 0) {
				do {
					current = (current + 1) == n ? 0 : current + 1;
				} while (array[current]);

				time--;
			}

			array[current] = true;
			eliminated++;


		}
		
		for (int i = 0; i < n; i++) {
			if (!array[i])
				return i + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new CandidateCode().getWinner(6, 3));
	}
}