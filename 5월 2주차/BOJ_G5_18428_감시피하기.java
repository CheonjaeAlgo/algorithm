package 똥;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/18428
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G5_18428_감시피하기 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static String ans;
	static char matrix[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		matrix = new char[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				matrix[r][c] = st.nextToken().charAt(0);
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (matrix[r][c] == 'T') {
					DFS(new Point(r, c));
				}
				else if(matrix[r][c]=='S')
					cnt++;
			}
		}

	}

	public static void DFS(Point p) {
		Queue<Point> queue = new LinkedList<Point>();

		queue.add(p);

		while (!queue.isEmpty()) {
			Point teacher = queue.poll();
			int x = teacher.x;
			int y = teacher.y;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(!(nx>=0 && nx<N && ny>=0 &&ny<N))
					continue;
				
			}
		}

	}
}
