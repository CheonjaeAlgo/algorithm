package _1월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/5397
 * 
 * @author Zizon_Yonni
 *
 */

public class BOJ_S2_5397_키로거 {

	static int testCase;
	static int cursor;
	static LinkedList<Character> password;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			// 백스페이스 -
			// 화살표 <>
			password = new LinkedList<Character>();
			String input = br.readLine();
			int length = input.length();
			cursor = 0; // 아무것도 입력되지 않은 상태

			for (int i = 0; i < length; i++) {

				int passwordLength = password.size();
				char ch = input.charAt(i);

//				System.out.println("i : " + i);
//				System.out.println("현재 입력된 :" + passwordLength);

				if (passwordLength == 0) {
					if (ch == '<' || ch == '>' || ch == '-')
						cursor = 0;
					else
						password.add(cursor++, ch);
				} else {
					if (ch == '<') {
						cursor--;
						if (cursor < 0)
							cursor = 0;
					}

					else if (ch == '>') {
						cursor++;
						if (cursor > passwordLength)
							cursor = passwordLength;
					}

					else if (ch == '-') {
						// cursor--;
						if (cursor < 0)
							password.remove(0);
						else
							password.remove(--cursor);
					} else {
						password.add(cursor, ch);
						cursor++;
					}

				}

//				System.out.println("현재 cursor index :" + cursor);
//				System.out.println(input.charAt(i));
//				System.out.println("\n");
			}

			Iterator iter = password.iterator();
			while (iter.hasNext()) {
				sb.append(iter.next());
			}
			sb.append("\n");

		}

		System.out.println(sb);
	}

}
