package _1월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11054
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G4_11054_가장긴바이토닉부분수열 {
	static int N;
	static int arr[];
	static int dpMax[];
	static int dpMin[];
	static int ans = 1;
	static int max;
	static int maxIndex;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dpMax = new int[N];
		dpMin = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			dpMax[i] = 1;
			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i]) {
					dpMax[i] = Integer.max(dpMax[i], dpMax[j] + 1);
				}

			}
		}
		for (int i = N - 1; i >= 0; i--) {
			dpMin[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (arr[j] < arr[i]) {
					dpMin[i] = Integer.max(dpMin[i], dpMin[j] + 1);
				}

			}
		}
		for (int i = 0; i < N; i++) {
			ans = Integer.max(dpMax[i]+dpMin[i], ans);
		}
		System.out.println(ans-1);
	}

}
