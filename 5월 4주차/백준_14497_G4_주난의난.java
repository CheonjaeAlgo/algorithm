package _5월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/14497
 * 
 * @author Zizon_Yonni
 *
 */
public class 백준_14497_G4_주난의난 {

	static public class Point implements Comparable<Point> {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o2) {

			return Integer.compare(this.cnt, o2.cnt);
		}
	}

	static int N, M;
	static char[][] matrix;
	static boolean[][] visited;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new char[N][M];
		visited = new boolean[N][M];

		st = new StringTokenizer(br.readLine());

		Point position = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
		Point target = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = input.charAt(j);
			}
		}

		BFS(position, target);

		System.out.println(ans);

	}

	public static void BFS(Point p, Point target) {
		PriorityQueue<Point> q = new PriorityQueue<Point>();

		q.offer(p);

		while (!q.isEmpty()) {

			Point cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (!(nx >= 0 && nx < N && ny >= 0 && ny < M))
					continue;

				if (visited[nx][ny])
					continue;

				if (matrix[nx][ny] == '0') {
					q.offer(new Point(nx, ny, cnt));
				}

				if (matrix[nx][ny] == '1') {
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny, cnt + 1));

				} else if (nx == target.x && ny == target.y) {
					ans = cnt + 1;
					return;
				}

			}
		}

	}

}
