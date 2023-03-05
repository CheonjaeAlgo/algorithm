package _3월1주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/17471
 * 
 * @author Zizon_Yonni
 *
 */

public class BOJ_G4_17471_게리맨더링 {

	static int N;
	// static ArrayList<ArrayList<Integer>> graph = new
	// ArrayList<ArrayList<Integer>>();
	static boolean[][] adjList;
	static int[] arr;
	static boolean[] selected;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		adjList = new boolean[N + 1][N + 1];
		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int idx = Integer.parseInt(st.nextToken());
				adjList[i][idx] = true;
				adjList[idx][i] = true;
			}
		}

		// 최솟값을 찾고 구역을 나눠야겠다

		for (int i = 1; i < N / 2 + 1; i++) {
			selected = new boolean[N + 1];
			combination(0, 1, i);
		}
		if (min != Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println("-1");

	}

	static int min = Integer.MAX_VALUE;

	public static void combination(int start, int index, int R) {
		if (index == R) {
			if (!isChecked())
				return;

			int diff = getDiff();

			min = Math.min(min, diff);
		}

		for (int i = index; i < N + 1; i++) {
			selected[index] = true; // true : A구역 false : B구역
			combination(index + 1, i + 1, i);
			selected[index] = false;
		}
	}

	public static boolean isChecked() {

		check = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				dfs(i, true);
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!selected[i]) {
				dfs(i, false);
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				return false;
			}
		}

		return true;
	}

	public static void dfs(int from, boolean area) {
		check[from] = true;

		for (int to = 1; to < N + 1; to++) {
			if (adjList[from][to] && !selected[to] == area && !check[to])
				dfs(to, area);
		}
	}

	public static int getDiff() {
		int a = 0;
		int b = 0;

		for (int i = 1; i <= N; i++) {
			// A구역이라면
			if (selected[i]) {
				a += arr[i];
			}
			// B구역이라면
			else {
				b += arr[i];
			}
		}

		return Math.abs(a - b);
	}

}
