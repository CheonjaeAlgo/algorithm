package _2월4주차;
import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11656
 * 
 * @author Zizon_Yonni
 */
public class BOJ_S4_11656_접미사배열 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		for (int i = 0; i < input.length(); i++) {
			pq.add(input.substring(i));
		}
		
		while(!pq.isEmpty()) 
		{
			sb.append(pq.poll()).append("\n");
		}

		System.out.println(sb);
	}

}
