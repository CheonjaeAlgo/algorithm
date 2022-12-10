package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2583_S1_영역구하기 {

	static int N, M, K;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[][] matrix;

	static ArrayList<Integer> List;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		matrix = new int[M][N];
		List = new ArrayList<Integer>();

		// input 저장
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
//			Point newSquare = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
//			square[i]=newSquare;
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int r = y1; r < y2; r++) {
				for (int c = x1; c < x2; c++) {
					matrix[r][c] = 1;
				}
			}

		}

		// DFS
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (matrix[r][c] == 0) {
					cnt = 0;
					DFS(r, c);
					List.add(cnt);
				}
			}
		}
		
		System.out.println(List.size());

	}

	public static void DFS(int r, int c) {
		matrix[r][c] = 1;
		cnt++;

		for (int d = 0; d < 4; d++) {
			int nx = d + dx[d];
			int ny = c + dy[d];

			if (nx >= 0 && ny == 0 && nx < M && ny < N) {
				if (matrix[nx][ny] == 0)
					DFS(nx, ny);
			}
		}
	}

}
