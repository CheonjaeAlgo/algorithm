package _3월5주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/11049
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G3_11049_행렬곱셈순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[][] a = new int[n][2];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {

				dp[j][j + i] = Integer.MAX_VALUE;

				for (int k = 0; k < i; k++) {

					int cost = dp[j][j + k] + dp[j + k + 1][j + i] + a[j][0] * a[j + k][1] * a[j + i][1];
					dp[j][j + i] = Math.min(dp[j][j + i], cost);
				}
			}
		}

		System.out.println(dp[0][n - 1]);

	}

}
