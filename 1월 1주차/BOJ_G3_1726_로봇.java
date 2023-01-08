import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1726
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G3_1726_로봇 {

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	// 동 서 남 북 1 2 3 4
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static class Point {
		int x;
		int y;
		int dir;
		int cnt;

		public Point(int x, int y, int dir, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M + 1][N + 1];
		visited = new boolean[M + 1][N + 1][5];

		for (int r = 1; r < M + 1; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c < N + 1; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// System.out.println(Arrays.deepToString(map));

		st = new StringTokenizer(br.readLine());
		Point position = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), 0);

		st = new StringTokenizer(br.readLine());
		Point target = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), 0);

		BFS(position, target);
	}

	public static void BFS(Point start, Point target) {
		Queue<Point> queue = new LinkedList<Point>();
		visited[start.x][start.y][start.dir] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			int dir = p.dir;
			int cnt = p.cnt;

			if (x == target.x && y == target.y && dir == target.dir) {
				System.out.println(cnt);
				return;
			}

			for (int i = 1; i <= 3; i++) {
				int nx = x + (dx[dir - 1] * i);
				int ny = y + (dy[dir - 1] * i);

				if (nx <= 0 || ny <= 0 || nx > M || ny > N)
					continue;

				if (map[nx][ny] == 0) {
					if (!visited[nx][ny][dir]) {
						visited[nx][ny][dir] = true;
						queue.add(new Point(nx, ny, dir, cnt + 1));
					}
				} else {
					break;
				}
			}

			for (int i = 1; i <= 4; i++) {
				if (dir != i && !visited[x][y][i]) {
					int turn = 1;
					if (dir == 1) {
						if (i == 2) {
							turn++;
						}
					} else if (dir == 2) {
						if (i == 1) {
							turn++;
						}
					} else if (dir == 3) {
						if (i == 4) {
							turn++;
						}
					} else {
						if (i == 3) {
							turn++;
						}
					}

					visited[x][y][i] = true;
					queue.add(new Point(x, y, i, cnt + turn));
				}
			}
		}
	}

}
