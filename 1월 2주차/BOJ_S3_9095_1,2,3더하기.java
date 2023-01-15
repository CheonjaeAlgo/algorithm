import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_S3_9095_1,2,3더하기 {

	static int testCase;
	static int n;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {

			n= sc.nextInt();
			int ans=function(n);
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);

	}

	public static int function(int n) {
		List<Integer> memo = new ArrayList<Integer>();
		;
		memo.add(0);
		memo.add(1);
		memo.add(2);
		memo.add(4);

		if (n >= 4) {
			for (int i = 4; i <= n + 1; i++) {
				memo.add(memo.get(i - 1) + memo.get(i - 2) + memo.get(i - 3));
			}
		}

		return memo.get(n);
	}
}
