package _3월5주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/15486
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G5_15486_퇴사2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		int[][] arr = new int[n + 2][2];
		int[] dp = new int[n + 2];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i][0] = t; // 기간
			arr[i][1] = p; // 금액
		}

		int max = -1;
		for (int i = 1; i < n + 1; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}

			int nxt = i + arr[i][0];
			if (nxt < n + 2) {
				dp[nxt] = Math.max(dp[nxt], max + arr[i][1]);
			}
		}
		System.out.println(dp[n + 1]);

	}

}
