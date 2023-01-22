import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2805
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_S2_2805_나무자르기 {

	static int N; // 나무
	static int M; // 나무길이
	static int trees[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int min = 0;
		int max = 0;
		trees = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (max < trees[i]) {
				max = trees[i];
			}
		}

		Arrays.sort(trees);

		// 이분 탐색 (upper bound)
		while (min < max) {

			int mid = (min + max) / 2;
			long sum = 0;
			for (int treeHeight : trees) {

				if (treeHeight - mid > 0) {
					sum += (treeHeight - mid);
				}
			}

			if (sum < M) {
				max = mid;
			}

			else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);

	}

}
