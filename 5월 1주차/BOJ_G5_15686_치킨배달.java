package 풀기싫어서죽겟네;

import java.io.*;
import java.util.*;

public class BOJ_G5_15686_치킨배달 {
	static int N, M;
	static int map[][];
	static LinkedList<Point> home, chicken;
	static int minResult = Integer.MAX_VALUE;
	static boolean[] selected;

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// map = new int[N][N];
		home = new LinkedList<Point>();
		chicken = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				// map[i][j] = Integer.parseInt(st.nextToken());

				if (num == 1)
					home.add(new Point(i, j));
				else if (num == 2)
					chicken.add(new Point(i, j));
			}
		}

		selected = new boolean[chicken.size()];
		/*
		 * for(int i=0; i<home.size();i++) { Point p = home.get(i); System.out.print(p.x
		 * +"\t"+p.y); } System.out.println(); System.out.println();
		 * 
		 * for(int i=0; i<chicken.size();i++) { Point p = chicken.get(i);
		 * System.out.println(p.x +"\t"+p.y); }
		 */
		DFS(0, 0);

		System.out.println(minResult);

	}

	public static void DFS(int cnt, int start) {
		int minDistance = Integer.MAX_VALUE;
		int result = 0;

		if (cnt == M) {
			result = 0;
			for (int i = 0; i < home.size(); i++) {
				minDistance = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (selected[j]) {
						int distance = getDistance(chicken.get(j).x, chicken.get(j).y, home.get(i).x, home.get(i).y);
						minDistance = Math.min(minDistance, distance);

					}
				}
				result += minDistance;
				// if (result >= minResult)
				// return;
			}
			// System.out.println(result);

			minResult = Math.min(minResult, result);

			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			selected[i] = true;
			DFS(cnt + 1, i + 1);
			selected[i] = false;
		}

	}

	public static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
