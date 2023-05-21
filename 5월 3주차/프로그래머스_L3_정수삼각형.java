package _5월3주차;

import java.io.*;
import java.util.*;

public class 프로그래머스_L3_정수삼각형 {
	static class Solution {
		static int[][] dp;

		public int solution(int[][] triangle) {

			int length = triangle.length;

			System.out.println(length);

			int[][] matrix = new int[length + 1][length + 1];
			dp = new int[length + 1][length + 1];

			for (int i = 0; i < length; i++) {
				int num = triangle[i].length;

				for (int j = 0; j < num; j++) {
					matrix[i + 1][j + 1] = triangle[i][j];
				}
			}

			dp[1][1] = matrix[1][1];

			for (int i = 1; i < length + 1; i++) {
				// int num = triangle[i].length;

				for (int j = 1; j < length + 1; j++) {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + matrix[i][j], dp[i - 1][j] + matrix[i][j]);
				}
			}

			int answer = 0;

			// for(int i=0; i<length+1;i++)
			// {
			// for(int j=0; j<length+1;j++)
			// {
			// System.out.print(dp[i][j]+ " ");
			// }
			// System.out.println();
			// }

			for (int i = 1; i < length + 1; i++) {
				answer = Integer.max(answer, dp[length][i]);
			}

			return answer;
		}
	}
}
