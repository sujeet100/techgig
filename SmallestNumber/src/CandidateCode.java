import java.io.*;

public class CandidateCode {

	private static class Steps {
		public int num;
		public int steps;

		public Steps(int num, int steps) {
			this.num = num;
			this.steps = steps;
		}
	}

	public static int smallest_number(int number) {
		Steps n1 = getStepsForMul(number);
		Steps n2 = getStepsForAdd(number);

		for (int i = number+1; i < 1000000000; i++) {
			Steps m1 = getStepsForMul(i);
			Steps m2 = getStepsForAdd(i);
			if (m1.steps <= n1.steps && m2.steps <= n2.steps && m1.num == n1.num
					&& m2.num == n2.num)
				return i;
		}
		return -1;
	}

	private static Steps getStepsForMul(int number) {
		int steps = 0;
		while (number >=10) {
			String str = Integer.toString(number);
			number = 1;
			for (int i = 0; i < str.length(); i++) {
				number = number * Character.getNumericValue(str.charAt(i));
			}
			steps++;
		}

		return new Steps(number, steps);
	}

	private static Steps getStepsForAdd(int number) {
		int steps = 0;
		while (number >= 10) {
			String str = Integer.toString(number);
			number = 0;
			for (int i = 0; i < str.length(); i++) {
				number = number + Character.getNumericValue(str.charAt(i));
			}
			steps++;
		}

		return new Steps(number, steps);
	}
	
	public static void main(String[] args) {
		System.out.println(new CandidateCode().smallest_number(2345));
	}
}