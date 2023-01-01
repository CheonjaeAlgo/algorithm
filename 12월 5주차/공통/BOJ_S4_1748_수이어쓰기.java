package _12_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1748
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_S4_1748_수이어쓰기 {

	static int N, result;
	static int pos; // 자리수
	static int addNum = 1;
	static int num = 10;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = Integer.parseInt(input);

		for (int i = 1; i <= N; i++) {
			// 자릿수 바뀌는 조건 => 10, 100, 1000, 10000, ...
			if (i % num == 0) {
				addNum++;
				num *= 10;
			}
			pos += addNum;

		}

		System.out.println(pos);
	}

}
