import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/5052
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G4_5052_전화번호목록 {

	static int testCase; // 테스트케이스
	static int N; // 전화번호부 수
	static ArrayList<String> telNum;

	static boolean result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		testCase = Integer.parseInt(br.readLine());

		for (int t = 0; t < testCase; t++) {
			N = Integer.parseInt(br.readLine());

			telNum = new ArrayList<String>();

			for (int i = 0; i < N; i++) {
				telNum.add(br.readLine());
			}

			// 길이순 정렬
//			Collections.sort(telNum, (o1, o2) -> {
//				return Integer.compare(o1.length(), o2.length());
//			});
			// 오름차순 정렬
			Collections.sort(telNum);

			// System.out.println(telNum.toString());

			result = verifySimilarity();
			sb.append(result ? "YES" : "NO").append("\n");

		}
		System.out.println(sb);

	}

	public static boolean verifySimilarity() {

		for (int i = 0; i < N - 1; i++) {
			if (telNum.get(i + 1).startsWith(telNum.get(i)))
				return false;

		}

		return true;
	}

}
