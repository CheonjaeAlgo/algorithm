package 풀기싫어서죽겟네;

import java.io.*;
import java.util.*;

public class BOJ_G3_8972_미친아두이노 {

	public static class Arduino {
		int x;
		int y;

		public Arduino(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int R, C;
	static String status;
	static char[][] matrix;
	static int dx[] = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int dy[] = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static Arduino jongsoo;
	static LinkedList<Arduino> list = new LinkedList<Arduino>();
	static boolean isBroken;
	static int cnt = 1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		matrix = new char[R][C];

		for (int r = 0; r < R; r++) {
			String input = br.readLine();
			for (int c = 0; c < C; c++) {
				char ch = input.charAt(c);
				matrix[r][c] = ch;

				if (ch == 'I') {
					jongsoo = new Arduino(r, c);
				} else if (ch == 'R') {
					list.add(new Arduino(r, c));
				}

			}
		}
		status = br.readLine();
		int length = status.length();

		for (int i = 0; i < length; i++) {

			int s = status.charAt(i) - '0';

			matrix[jongsoo.x][jongsoo.y] = '.';

			jongsoo.x = jongsoo.x + dx[s];
			jongsoo.y = jongsoo.y + dy[s];

			if (matrix[jongsoo.x][jongsoo.y] == 'R') {
				isBroken = true; // 폭발..
				break;
			}

			matrix[jongsoo.x][jongsoo.y] = 'I';

			if (!arduinoMoving()) {
				isBroken = true;
				break;
			}
			cnt++;
		}

		if (isBroken) {
			sb.append("kraj").append(" ").append(cnt);
		} else {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(matrix[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

//		for (int r = 0; r < R; r++) {
//			for (int c = 0; c < C; c++) {
//				System.out.print(matrix[r][c] + " ");
//			}
//			System.out.println("\n");
//		}
//		System.out.println(status);

	// return 값 true : 종수터짐
	public static boolean arduinoMoving() {
		int[][] arduino_cnt = new int[R][C];
		int size = list.size();

		for (int i = 0; i < size; i++) {
			Arduino cur = list.poll();

			int x = cur.x;
			int y = cur.y;

			matrix[x][y] = '.';

			int direction = findDirection(cur);

			int nx = x + dx[direction];
			int ny = y + dy[direction];

			if (matrix[nx][ny] == 'I')
				return false;

			arduino_cnt[nx][ny]++;

		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arduino_cnt[i][j] == 1) {
					matrix[i][j] = 'R';
					list.add(new Arduino(i, j));
				}
			}
		}
		return true;
	}

	public static int findDirection(Arduino arduino) {
		int min = Integer.MAX_VALUE;
		int status = -1;
		int distance = 0;

		for (int d = 1; d < 10; d++) {
			int nx = arduino.x + dx[d];
			int ny = arduino.y + dy[d];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;

			distance = Math.abs(jongsoo.x - nx) + Math.abs(jongsoo.y - ny);
			if (min > distance) {
				min = distance;
				status = d;
//
//				if (distance == 0)
//					return true;

			}
		}

		return status;
	}

}
