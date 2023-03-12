package _3월2주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2252
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G3_2252_줄세우기 {

	static int N, M; // 학생수, 비교회수
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int[] enterDegree; // true : 진입차수 0개
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int n = 0; n <= N; n++) {
			graph.add(new ArrayList<Integer>());
		}

		enterDegree = new int[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int m = 0; m < M; m++) {

			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(B);

			enterDegree[B]++;
		}
		

		System.out.println(topology());

	}

	public static String topology() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i < N + 1; i++) {
			if (enterDegree[i] == 0) {
				q.offer(i);
				enterDegree[i] = -1;
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll(); // 현재 진입 노드

			sb.append(cur).append(" ");

			ArrayList<Integer> list = graph.get(cur);

			Iterator<Integer> iter = list.iterator();

			while (iter.hasNext()) {
				int next =  iter.next();

				enterDegree[next]--;
				iter.remove();

				if (enterDegree[next] == 0)
					q.offer(next);
			}

		}
		
		
		
		return sb.toString();
	}

}
