package _2월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/14675
 * @author Zizon_Yonni
 *
 */

public class BOJ_S1_14675_단절점과단절선 {

	static int N;// 정점
	static int Q;// 질의
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
			
		}
		
		Q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if(t==1) 
			{
				int size =graph.get(k).size();
				
				if(size<2)
					sb.append("no").append("\n");
				else
					sb.append("yes").append("\n");
			}
			else 
			{
				sb.append("yes").append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
