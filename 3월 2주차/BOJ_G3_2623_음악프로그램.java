package _3월2주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2623
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G3_2623_음악프로그램 {
	static int N, M; // 가수수, PD수
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int enterDegree[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		enterDegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

//			int size = Integer.parseInt(st.nextToken());
//			int cur = Integer.parseInt(st.nextToken());
//			while (st.hasMoreTokens()) {
//				int next = Integer.parseInt(st.nextToken());
//
//				
//				if (!graph.get(cur).contains(next)) {
//					graph.get(cur).add(next);
//					enterDegree[next]++;
//				}
//				cur = next;
//			}

			int num = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken());
			for (int j = 1; j < num; j++) {
				int singer = Integer.parseInt(st.nextToken());
				graph.get(before).add(singer);
				enterDegree[singer]++;

				before = singer;
			}

		}

		System.out.println(topology());

	}

	public static String topology() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i < N + 1; i++) {
			if (enterDegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			result.add(cur);

			  for (int next : graph.get(cur)) {
				  enterDegree[next]--;
	 
	                if (enterDegree[next] == 0) {
	                    q.offer(next);
	                }
	            }

		}


		if (result.size() != N)
			return "0";
		else
		{
			for(int i : result) 
			{
				sb.append(i).append("\n");
			}
			return sb.toString();
		}

	}

}
