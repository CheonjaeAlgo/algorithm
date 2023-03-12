package _3월2주차;

import java.util.*;
import java.io.*;

public class BOJ_S4_11399_ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(arr);

		int prev = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += prev + arr[i];

			prev += arr[i];
		}
		System.out.println(sum);

	}

}
