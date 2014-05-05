import java.io.*;

public class CandidateCode {
	public static int get_height(String[] students) {
		int count = 0;

		for (int i = 0; i < students.length; i++) {
			int student1_ft = Integer.parseInt(students[i].split("#")[0]);
			int student1_in = Integer.parseInt(students[i].split("#")[1]);

			for (int j = i + 1; j < students.length; j++) {
				int student2_ft = Integer.parseInt(students[j].split("#")[0]);
				int student2_in = Integer.parseInt(students[j].split("#")[1]);

				if (student1_ft < 4 || student1_ft > 7 || student1_in < 0
						|| student1_in > 11)
					return -1;

				if ((student1_ft == student2_ft && student1_in > student2_in)
						|| student1_ft > student2_ft) {
					count++;
				}

			}

		}

		return count;
	}
}