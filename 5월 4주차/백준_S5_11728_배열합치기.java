package _5월4주차;
import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11728
 * 
 * @author Zizon_Yonni
 *
 */
public class 백준_S5_11728_배열합치기 {

	static int N,M;
	static int [] arr1,arr2;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<2;i++) 
		{
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) 
			{
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		while(!pq.isEmpty()) 
		{
			sb.append(pq.poll()).append(" ");
		}
		
		System.out.println(sb);
		
//		arr1 = new int [N];
//		arr2 = new int [M];
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0;i<N;i++) 
//		{
//			arr1[i]= Integer.parseInt(st.nextToken());
//		}
//		st = new StringTokenizer(br.readLine());
//		for(int i=0;i<M;i++) 
//		{
//			arr2[i]= Integer.parseInt(st.nextToken());
//		}
	}

}
