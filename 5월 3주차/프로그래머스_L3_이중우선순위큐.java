package _5월3주차;

import java.io.*;
import java.util.*;
public class 프로그래머스_L3_이중우선순위큐 {
	class Solution {

		// System.out.println();
		public int[] solution(String[] operations) {

			int length = operations.length;
			PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());

			for (int i = 0; i < length; i++) {
				StringTokenizer st = new StringTokenizer(operations[i]);
				char op = st.nextToken().charAt(0);

				if (op == 'I') {
					int num = Integer.parseInt(st.nextToken());
					// System.out.println("삽입 "+num);
					pq1.offer(num);
					pq2.offer(num);
				} else if (op == 'D') {
					String op2 = st.nextToken();
					// System.out.println(op2);
					if (!pq1.isEmpty()) {
						if (op2.equals("1")) {

							pq1.remove(pq2.poll());

						} else if (op2.equals("-1")) {

							pq2.remove(pq1.poll());

						}
					}
				}
			}

			int[] ans = new int[2];

			System.out.println(pq1.size());
			System.out.println(pq2.size());

			if (pq1.size() > 0) {
				ans[0] = pq2.poll();
				ans[1] = pq1.poll();
			}

			return ans;
		}
	}
}
