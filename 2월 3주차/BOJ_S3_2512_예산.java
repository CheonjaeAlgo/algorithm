package _2월3주차;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2512
 * @author Zizon_Yonni
 *
 */

public class BOJ_S3_2512_예산 {

	static int N,M;
	static int [] arr;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		
		arr =new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		M=  Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		long left = 0;
		long right = arr[N-1];
		long ans =0;
		while(left<=right) 
		{
			long mid = (left+right)/2;
			long sum=0;
			
			for (int i = 0; i < N; i++) {
				if(arr[i]>mid) sum += mid;
				else sum+= arr[i];
			}
			
			
			if(sum<=M) 
			{
				ans=mid;
				left =mid+1;
			}
			else {
				right=mid-1;
			}
		}
		
		System.out.println(ans);
	}

}
