package _2월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1913
 * 
 * @author Zizon_Yonni
 */
public class BOJ_S3_1966_프린터큐 {

	public static class Printer implements Comparable<Printer> {
		int num;
		int priority;

		public Printer(int num, int priority) {
			this.num = num;
			this.priority = priority;
		}

		@Override
		public int compareTo(Printer p) {
			return -Integer.compare(this.priority, p.priority);
		}

	}

	static int testCase;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		testCase = Integer.parseInt(br.readLine());

		for (int t = 0; t < testCase; t++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			LinkedList<Printer> q = new LinkedList<Printer>();

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				q.offer(new Printer(i, Integer.parseInt(st.nextToken())));
			}
			int cnt = 0;
			while (true) {
				Printer front = q.poll();

				boolean isMax = true;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					if (front.priority < q.get(i).priority) {
						q.offer(front);

						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						isMax = false;
						break;
					}
				}

				if (isMax == false) {
					continue;
				}

				// front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
				cnt++;
				if (front.num == target) { // 찾고자 하는 문서라면 해당 테스트케이스 종료
					break;
				}
			}

			sb.append(cnt).append("\n");

		}

		System.out.println(sb);

	}

}
