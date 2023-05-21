package _5월3주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/17951
 * 
 * @author Zizon_Yonni
 *
 */
public class 백준_G4_17951_흩날리는시험지속에서내평점이느껴진거야 {
	static int N, K;
	static long arr[];
	static long min = Long.MAX_VALUE, sum,cnt=1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(st.nextToken());
			arr[i] = score;
			sum += score;
		}

		long left = 0;
		long right = sum;

		while (left <= right) {
			long mid = (left + right) / 2;
			sum = 0;
			min=Long.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				sum+=arr[i];
				
				if (sum >= mid) {
					cnt++;
					min = Math.min(min, sum);
					sum = 0;
				}
			}
			
			if (cnt > K)
				left = mid + 1;
			else
				right = mid - 1;
		}
		
		System.out.println(left-1);

	}

}
