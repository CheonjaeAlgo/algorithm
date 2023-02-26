package _2월4주차;

import java.io.*;
import java.util.*;

public class BOJ_S4_16499_동일한단어그룹화하기 {
	static int N;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			
			 char[] chars =br.readLine().toCharArray();
		     Arrays.sort(chars);
		     String str = new String(chars);
			
			map.put(str, 0);
		}
		
		System.out.println(map.size());
	}

}
