package 풀기싫어서죽겟네;

import java.io.*;
import java.util.*;

public class BOJ_S4_1543_문서검색 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb.append(br.readLine());
		String find = br.readLine();

		search(find);

	} // End of main

	static void search(String find) {

		int count = 0;
		int startIndex = 0;
		int find_len = find.length();

		while ((startIndex = sb.toString().indexOf(find)) != -1) {
			sb.delete(0, startIndex + find_len);
			count++;
		}

		System.out.println(count);
	}
}
