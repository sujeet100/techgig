import java.util.Scanner;


public class Snape {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();
		for (int i=0; i<noOfTests;i ++) {
			int B = in.nextInt();
			int LS = in.nextInt();
			float maxRS = (float) Math.sqrt(B*B+LS*LS);
			float minRS = (float) Math.sqrt(LS*LS-B*B);
			System.out.print(minRS+" "+maxRS+"\n");
			
		}
	}
}
