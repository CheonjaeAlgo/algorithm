package _3월5주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/9536
 * 
 * @author Zizon_Yonni
 *
 */

public class BOJ_S4_9536_여우는어떻게울지 {

	static int T;
	static String input;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		ArrayList<String> list = new ArrayList<>();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}

			while (true) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				st.nextToken();

				String sound = st.nextToken();

				if (sound.equals("the")) {
					st.nextToken();
					st.nextToken();
					break;
				}

				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).equals(sound)) {
						list.remove(j);
						j--;
					}
				}
			}

			for (int j = 0; j < list.size(); j++)
				sb.append(list.get(j) + " ");
			System.out.println(sb.toString());
			sb.setLength(0);
			list.clear();
		}
	}

}
