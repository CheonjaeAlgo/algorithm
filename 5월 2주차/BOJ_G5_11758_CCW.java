package 똥;

import java.io.*;
import java.util.*;

public class BOJ_G5_11758_CCW {

	static int inclination1, inclination2;
	static int ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());

		ans = ccw(x1,x2,x3,y1,y2,y3);
		
		System.out.println(ans);

	}
	public static int ccw(int x1, int x2, int x3,int y1,int y2, int y3) {
		// CCW 공식 (x1y2+x2y3+x3y1)−(y1x2+y2x3+y3x1)
		int a = x1 * y2 + x2 * y3 + x3 * y1;
		int b = y1 * x2 + y2 * x3 + y3 * x1;

		// 반시계 방향
		if (a - b > 0) {
			return 1;
		} else if (a == b) { // 평행
			return 0;
		} else { // 시계 방향
			return -1;
		}
	}

}
