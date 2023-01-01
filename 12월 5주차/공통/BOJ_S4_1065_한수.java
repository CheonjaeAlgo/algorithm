package _12_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1065
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G4_1065_한수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;

		if (N < 100)
			result = N;
		else {

			for (int i = 100; i <= N; i++) {

				int pos100 = i / 100;
				int pos10 = (i % 100) / 10;
				int pos1 = (i % 100) % 10;

				if ((pos100 - pos10) == (pos10 - pos1))
					result++;
			}

			result += 99;
		}

		System.out.println(result);

	}

}
