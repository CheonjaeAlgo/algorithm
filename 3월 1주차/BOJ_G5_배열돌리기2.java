package _3월1주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/16927
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G5_배열돌리기2 {
	static int N, M, R;
	static int[][] matrix;
	static int[][] copy_matrix;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		matrix = new int[N][M];
		copy_matrix = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken());
				copy_matrix[r][c] = matrix[r][c];
			}
		}

		int n = N;
		int m = M;
		int size = Math.min(N, M)/2;

		for (int i = 0; i < size; i++) {
			// i 회전을 시작하는 좌표
			rotate(i, 2 * n + 2 * m - 4);
			n -= 2;
			m -= 2;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(matrix[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static void rotate(int start, int len) {
		int rLen = R % len;

		for (int i = 0; i < rLen; i++) {
			int x = start;
			int y = start;

			int pre = matrix[start][start];
			int temp = 0;
			int d = 0;

			while (d < 4) {
				int nx = x + dx[d];
				int ny = y + dy[d];

//				if(!(nx>=start && nx<N-start && ny>= start && ny<M-start)) 
//				{
//					d++;
//					continue;
//				}

				if (nx >= start && nx < N - start && ny >= start && ny < M - start) {
					temp = matrix[nx][ny];
					matrix[nx][ny] = pre;
					pre = temp;
					x = nx;
					y = ny;
				} else {
					d++;
				}

			}

		}
	}
}
