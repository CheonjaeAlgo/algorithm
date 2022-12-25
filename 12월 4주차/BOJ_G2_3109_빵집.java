package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * https://www.acmicpc.net/problem/3109
 * @author Zizon_Yonni
 *
 */
public class BOJ_G2_3109 {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;

	static int cnt = 0;

	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		for(int i=0;i<R;i++) 
		{
			if(DFS(i,0)) cnt++;
		}
		System.out.println(cnt);

	} // main함수 종료

	static int temp = 0;

	public static boolean DFS(int x, int y) {

		for (int d = 0; d < 3; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if (visited[nx][ny] == false && map[nx][ny]=='.') {
					visited[nx][ny]=true;
					if(C-1==ny) return true;
					if(DFS(nx,ny)) return true;
				}
			}
		}
		return false;
	}
}
