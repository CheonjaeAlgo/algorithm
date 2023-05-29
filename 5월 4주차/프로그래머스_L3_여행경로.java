package _5월4주차;
import java.util.*;

public class 프로그래머스_L3_여행경로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Solution {

		static int N;
		static boolean visited[];
		static ArrayList<String> lists = new ArrayList<String>();

		public String[] solution(String[][] tickets) {
			String[] answer = {};

			N = tickets.length;
			visited = new boolean[N];

			DFS("ICN", "ICN", tickets, 0);

			Collections.sort(lists);
			System.out.println(lists.get(0));
			answer = lists.get(0).split(" ");

			return answer;
		}

		public static void DFS(String start, String route, String[][] tickets, int cnt) {
			if (cnt == N) {
				lists.add(route);
				return;
			}

			for (int i = 0; i < N; i++) {
				if (start.equals(tickets[i][0]) && !visited[i]) {
					visited[i] = true;
					DFS(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
					visited[i] = false;
				}
			}

		}

	}
}
