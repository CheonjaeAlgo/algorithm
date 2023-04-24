package 풀기싫어서죽겟네;

import java.io.*;
import java.util.*;

public class BOJ_S2_2210_숫자판점프 {

	static String[][] matrix = new String[5][5];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				matrix[r][c] = st.nextToken();
			}
		}

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				DFS(r, c, 0, matrix[r][c]);
			}
		}
		System.out.println(list.size());

	}

	public static void DFS(int x, int y, int cnt, String str) {
		if (cnt == 5) {
			if (!list.contains(str))
				list.add(str);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5)
				DFS(nx, ny, cnt + 1, str + matrix[nx][ny]);
		}
	}

}
