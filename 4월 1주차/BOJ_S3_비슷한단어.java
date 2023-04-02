package _4월1주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2607
 * 
 * @author Zizon_Yonni
 *
 */

public class BOJ_S3_비슷한단어 {

	static int N;
	static int result;
	static int alph[] = new int[26];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine())-1;

		String input = br.readLine();
		for (int i = 0; i < N; i++) {
			String compare = br.readLine();
			char first[] = input.toCharArray();
			char next[] = compare.toCharArray();

			int contain = 0;

			for (int j = 0; j < next.length; j++) {
				for (int k = 0; k < first.length; k++) {

					if (next[j] == first[k]) {
						next[j] = '1';
						first[k] = '2';
						contain++;
					}
				}
			}

			if ((contain >= first.length - 1 && first.length >= next.length)
					|| (contain >= next.length - 1 && next.length >= first.length))
				result++;

			// if(contain >= compare.length()-1 || contain == first.length || (contain >=
			// first.length-1 && first.length > compare.length())) ans++;
		}
		System.out.println(result);
	}
}
