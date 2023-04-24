package 풀기싫어서죽겟네;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/13459
 * 
 * @author Zizon_Yonni
 *
 */

// 빨간구슬 파란구슬 넣고 빨간구술빼라
public class BOJ_G1_13459_구슬탈출 {

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static char[][] matrix;
	static int ans = -1;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static Point red, blue;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new char[N][M];

		for (int r = 0; r < N; r++) {
			String input = br.readLine();
			for (int c = 0; c < M; c++) {
				matrix[r][c] = input.charAt(c);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 'B') {
					blue = new Point(i, j);
					matrix[i][j] = '.';
				} else if (matrix[i][j] == 'R') {
					red = new Point(i, j);
					matrix[i][j] = '.';
				}
			}
		}
		if (DFS(0, -1, red, blue)) {
			ans = 1;
		} else {
			ans = 0;
		}
		System.out.println(ans);

	}

	public static boolean DFS(int cnt, int pd, Point r, Point b) {
		if (cnt == 10) {
			return false;
		}
		
		Point copyR = null;
		Point copyB = null;
		for (int d = 0; d < 4; d++) {
			if (d == pd)
				continue;
			copyR = moving(r.x, r.y, d);
			copyB = moving(b.x, b.y, d);

			if (matrix[copyR.x][copyR.y] == 'O' && matrix[copyB.x][copyB.y] != 'O') {
				return true;
			} else if (matrix[copyB.x][copyB.y] == 'O') {
				continue;
			} else if (copyR.x == copyB.x && copyR.y == copyB.y) {
				if (d == 0) {
					if (r.x < b.x) {
						copyR.x -= 1;
					} else {
						copyB.x -= 1;
					}
				} else if (d == 1) {
					if (r.x > b.x) {
						copyR.x += 1;
					} else {
						copyB.x += 1;
					}
				} else if (d == 2) {
					if (r.y < b.y) {
						copyR.y -= 1;
					} else {
						copyB.y -= 1;
					}
				} else if (d == 3) {
					if (r.y > b.y) {
						copyR.y += 1;
					} else {
						copyB.y += 1;
					}
				}
			}

			if (DFS(cnt + 1, d, copyR, copyB))
				return true;
		}

		return false;
	}

	public static Point moving(int x, int y, int d) {
		Point ball = null;
		int ny, nx;
		while (true) {
			nx = x + dx[d];
			ny = y + dy[d];
			
//			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
//				break;
			
			if (matrix[nx][ny] == 'O') {
				ball = new Point(nx, ny);
				break;
			} else if (matrix[nx][ny] == '#') {
				ball = new Point(x, y);
				break;
			}
			x = nx;
			y = ny;
		}

		return ball;
	}

}
