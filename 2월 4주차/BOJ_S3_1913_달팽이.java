package _2월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1913
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_S3_1913_달팽이 {

	static int N, target;
	static int[][] matrix;
	static int dx[] = { 1, 0, -1, 0 }; // 하우상좌
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		target = Integer.parseInt(br.readLine());

		matrix = new int[N][N];

		simulation();
		int x=0; int y=0;

		for (int i = 0; i < N; i++) {
			for(int j=0;j<N;j++) 
			{
				sb.append(matrix[i][j]).append(" ");
				if(matrix[i][j]==target) 
				{
					x=i+1;
					y=j+1;
				}
			}
			sb.append("\n");
		}
		
		sb.append(x).append(" " ).append(y);
		
		System.out.println(sb);


	}

	public static void simulation() {
		int r = 0;
		int c = 0;
		int count = N * N;
		int d = 0; // 방향

		while (true) {
			if (count == 0) {
				break;
			}
			matrix[r][c] = count--;
			int nr = r + dx[d];
			int nc = c + dy[d];
			int nd = setDirection(d, N, nr, nc);
			// 방향이 바뀌면 다음 방향을 기준으로 r,c를 업데이트.
			if (nd != d) {
				r = r + dx[nd];
				c = c + dy[nd];
				d = nd;
			} else {
				r = nr;
				c = nc;
			}
		}
	}

	public static int setDirection(int d, int n, int nr, int nc) {
		// 범위를 벗어났거나
		if (nr >= n || nc >= n || nr < 0 || nc < 0) {
			d = (d + 1) % 4;
		}
		// 이후 있을 자리가 이미 값이 있거나
		else if (matrix[nr][nc] != 0) {
			d = (d + 1) % 4;
		}

		return d;
	}
}
