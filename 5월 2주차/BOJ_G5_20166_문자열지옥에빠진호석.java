package 똥;

import java.io.*;
import java.util.*;

public class BOJ_G5_20166_문자열지옥에빠진호석 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static char[][] map;
	static int[][][] DP;
	static int[] answer;
	static int N, M, K, size;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		K = Integer.parseInt(st.nextToken()); // 신이 좋아하는 문자열 개수
		answer = new int[K];
		int idx = 0;
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[i] = st.nextToken().toCharArray();
		} // input

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String target = st.nextToken();
			size = target.length();
			DP = new int[N][M][size]; // 최대 문자열의 길이 5개니까.

			for (int s = size - 1; s >= 0; s--) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						// 일단 시작점 같은 곳 찾고
						if (map[r][c] == target.charAt(s)) {
							// dfs(r, c, s + 1, i, target, r, c);
							update(r, c, s + 1, target);

							// target 문자열의 처음 이라면
							if (s == 0) {
								answer[idx] += DP[r][c][s];
							}

						}
					}
				}
			} // update
			idx++;

		} // input

		for (int output : answer) {
			System.out.println(output);
		} // answer
	}

	private static void update(int r, int c, int idx, String target) {
		if (idx == size) {
			DP[r][c][idx - 1]++;
			return;
		}

		// 8방 서치 하면서
		for (int d = 0; d < 8; d++) {

			int nr = r + dr[d];
			int nc = c + dc[d];

			nr = updateR(nr);
			nc = updateC(nc);

			if (map[nr][nc] == target.charAt(idx)) {
				DP[r][c][idx - 1] += DP[nr][nc][idx];
			}

		}
	}

	private static int updateR(int r) {

		if (r >= N)
			return 0;
		else if (r < 0)
			return N - 1;

		return r;
	}

	private static int updateC(int c) {

		if (c >= M)
			return 0;
		else if (c < 0)
			return M - 1;

		return c;
	}

}
