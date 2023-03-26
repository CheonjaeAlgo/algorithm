package _3월5주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/9536
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_S2_11279_최대힙 {

	static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq  = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			
			int input = Integer.parseInt(br.readLine());
			
			if(input==0) 
			{
				if(pq.size()==0)
					sb.append("0").append("\n");
				else
					sb.append(pq.poll()).append("\n");
			}
			else 
			{
				pq.offer(input);
			}
			
		}
		System.out.println(sb);
	}

}
