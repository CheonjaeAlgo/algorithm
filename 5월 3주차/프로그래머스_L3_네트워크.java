package _5월3주차;

import java.io.*;
import java.util.*;

public class 프로그래머스_L3_네트워크 {
	static class Solution {
		static int cnt;
		static boolean visited[];

		// static ArrayList<Integer> graph = new ArrayList<Integer>();
		public int solution(int n, int[][] computers) {

			visited = new boolean[n];

			for (int i = 0; i < n; i++) {
				if (visited[i] == false) {
					cnt++;
					DFS(i, n, computers);
				}
			}

			int answer = cnt;
			return answer;
		}

		public void DFS(int i, int n, int[][] com) {
			visited[i] = true;

			for (int j = 0; j < n; j++) {
				if (!visited[j] && com[i][j] == 1)
					DFS(j, n, com);
			}
		}

	}
}
