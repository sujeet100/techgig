import java.util.ArrayList;
import java.util.List;

public class CandidateCode {

	public static String get_responce(int N, int M, String[] answers) {

		List<String> possibles = new ArrayList<String>();

		possibles.add("Y");
		possibles.add("N");

		for (int i = 1; i < N; i++) {

			List<String> newPossibles = new ArrayList<String>();
			for (String string : possibles) {
				newPossibles.add(string.concat("Y"));
				newPossibles.add(string.concat("N"));
			}
			possibles = newPossibles;
		}

		for (String possible : possibles) {
			boolean incorrectAnswer = false;
			for (String answer : answers) {
				int q1 = Integer.parseInt(answer.split("#")[0]);
				int q2 = Integer.parseInt(answer.split("#")[1]);
				if ((q1 < 0 && possible.charAt(Math.abs(q1)-1) == 'Y')
						&& (q2 < 0 && possible.charAt(Math.abs(q2)-1) == 'Y')) {
					incorrectAnswer = true;
				}

				if ((q1 > 0 && possible.charAt(Math.abs(q1)-1) == 'N')
						&& (q2 > 0 && possible.charAt(Math.abs(q2)-1) == 'N')) {
					incorrectAnswer = true;
				}

				if ((q1 < 0 && possible.charAt(Math.abs(q1)-1) == 'Y')
						&& (q2 > 0 && possible.charAt(Math.abs(q2)-1) == 'N')) {
					incorrectAnswer = true;
				}

				if ((q1 > 0 && possible.charAt(Math.abs(q1)-1) == 'N')
						&& (q2 < 0 && possible.charAt(Math.abs(q2)-1) == 'Y')) {
					incorrectAnswer = true;
				}

			}
			if (!incorrectAnswer)
				return "Yes";
		}

		return "No";
	}

	public static void main(String[] args) {
		System.out.println(new CandidateCode().get_responce(4, 5, new String[] {
				"1#2", "2#3", "3#4", "-1#-3","-2#4"}));
	}
}