package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/24480
 * @author Zizon_Yonni
 *
 */
public class BOJ_S2_24480_알고리즘수업_깊이우선탐색2 {

	static int N,M,R;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] check;
	static int cnt;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		check = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());

		}
		while (M-- > 0) { // 간선 수 만큼 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		// 내림차순 정렬
		for (int i = 1; i < graph.size(); i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}

		cnt = 1;
		dfs(R);

		for (int i = 1; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}

		System.out.println(sb);
	}
	
	public static void dfs(int node) {

		check[node] = cnt;
		for (int i = 0; i < graph.get(node).size(); i++) {
			int newNode = graph.get(node).get(i);
			if (check[newNode] == 0) {
				cnt++;
				dfs(newNode);
			}
		}

	}
}
