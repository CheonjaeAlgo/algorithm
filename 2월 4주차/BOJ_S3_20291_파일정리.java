package _2월4주차;

import java.io.*;
import java.util.*;

public class BOJ_S3_20291_파일정리 {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>();

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(),".");
			
			st.nextToken();
			String ext = st.nextToken();
			if (map.containsKey(ext)) {
				int tmp = map.get(ext);
				map.replace(ext, ++tmp);
			} else {
				map.put(ext, 1);
			}
		}

		for (String key : map.keySet()) {
			sb.append(key).append(" ").append(map.get(key)).append("\n");
		}
		
		System.out.println(sb);
	}

}
