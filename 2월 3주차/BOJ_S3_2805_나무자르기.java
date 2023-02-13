package _2월3주차;

import java.io.*;
import java.util.*;
/**
 * https://www.acmicpc.net/problem/2805
 * @author Zizon_Yonni
 * 매개변수 탐색하기
 */
public class BOJ_S3_2805_나무자르기 {

	static int N,M; 	// 나무의수 , 나무의 길이 (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
	static int[] arr;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long h =0;
		long left =0;
		long right =2000000000;
		
		while(left<=right) 
		{
			
			//System.out.println("높이 : "+h+" left : "+left+" right : "+right);
			
			
			long mid = (left+right)/2;
			// System.out.println(mid);
			
			if(check(mid)) {
				h = mid;
				left = mid+1;
			}
			else 
			{
				right = mid-1;
			}
		}
		//System.out.println("================");
		System.out.println(h);
		
		
	}
	
	public static boolean check(long h) 
	{
		long sum = 0;
		if(h >= arr[N-1])
			return false;

		for (int i = 0; i < N; i++) {
			long temp = arr[i];
			//나무가.. h보다 크면
			if(temp>h)
				sum += (temp -h); // 댕강
		}
		
		return sum>=M;
		
		
	
	}
	

}
