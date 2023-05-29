package _5월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2470
 * 
 * @author Zizon_Yonni
 *
 */

public class 백준_G5_2470_두용액 {

	static int N;
	static int [] arr;
	static long min = 2000000000L;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
	
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		int ans[] =new int[2];
		
		st = new StringTokenizer(br.readLine());
	
		for(int i=0; i<N; i++) 
		{
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left =0;
		int right =N-1;
		
		
		while(left<right) 
		{
			long sum = Math.abs(arr[left]+arr[right]);
			
			if(sum<min) 
			{
				min =sum;
				ans[0]=arr[left];
				ans[1]=arr[right];
			}
			
			if(arr[left]+arr[right]>0)
				right--;
			else
				left++;
			
		}
		
		sb.append(ans[0]).append(" ").append(ans[1]);
		
		System.out.println(sb);
		
	
	}

}
