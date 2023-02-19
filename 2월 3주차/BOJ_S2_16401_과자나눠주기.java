package _2월3주차;

import java.util.*;

import _2월3주차.BOJ_G4_24041_성싶당밀키트.Food;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/16401
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_S2_16401_과자나눠주기 {

	static int N, M;
	static int[] arr;
	static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());// TODO Auto-generated method stub

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long left = 1;
		long right = arr[N - 1];

		while (left <= right) {
			long mid = (left + right) / 2;
			if (check(mid)) {
				left = mid + 1;
				ans = mid;
			} else {
				right = mid - 1;
			}

		}

		System.out.println(ans);

	}

	static boolean check(long mid) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] >= mid)
				sum += arr[i] / mid;
		}

		return sum >= M;
	}

}
