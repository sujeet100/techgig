import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CandidateCode {
	public static int squareCount(int[] input) {
		int p = input[0];
		int q = input[1];
		int x = input[2];
		
		Map<Integer, Integer> jumpCounts = new HashMap<Integer, Integer>();
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < q; j++) {
				boolean[][] board = new boolean[p][q];
				int jumps = countJumps(p, q, x, board, i, j);

				if (jumpCounts.get(jumps) == null) {
					jumpCounts.put(jumps, 1);
				} else {
					jumpCounts.put(jumps, jumpCounts.get(jumps) + 1);
				}

			}

		}

		int maxKey = Collections.max(jumpCounts.keySet());
		System.out.println(jumpCounts);
		System.out.println(maxKey);
		System.out.println(jumpCounts.get(maxKey));
		return jumpCounts.get(maxKey);
	}

	private static int countJumps(int p, int q, int x, boolean[][] board,
			int i, int j) {
		int jumps = 0;
		if (i+x<p && !board[i + x][j]) {
			board[i + x][j] = true;
			jumps=1+countJumps(p, q, x, board, i+x, j);
		}

		if (j+x<q && !board[i][j + x]) {
			board[i][j + x] = true;
			jumps=1+countJumps(p, q, x, board, i, j+x);
		}

		if (i-x>=0 && !board[i - x][j] ) {
			board[i - x][j] = true;
			jumps=1+countJumps(p, q, x, board, i-x, j);
		}

		if (j-x>=0 && !board[i][j - x] ) {
			board[i][j - x] = true;
			jumps=1+countJumps(p, q, x, board, i, j-x);
		}
		return jumps;
	}
	
	public static void main(String[] args) {
		CandidateCode.squareCount(new int[]{3,3,2});
	}
}