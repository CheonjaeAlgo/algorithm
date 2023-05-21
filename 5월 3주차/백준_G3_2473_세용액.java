package _5월3주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2473
 * 
 * @author Zizon_Yonni
 *
 */

public class 백준_G3_2473_세용액 {
	static int N;
	static long[] arr;
	static long[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new long[N];
		ans = new long[3];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);

		for (int i = 0; i < N - 2; i++) {
			binarySearch(i);
		}

		Arrays.sort(ans);

		for (int i = 0; i < 3; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
		//System.out.println(max);

	}

	static long max = 3000000000L;

	public static void binarySearch(int idx) {
		int left = idx + 1;
		int right = N - 1;

		while (left < right) {
			long sum = arr[left] + arr[right] + arr[idx];
			long absSum = Math.abs(sum);

			if (absSum < max) {
				ans[0] = arr[left];
				ans[1] = arr[right];
				ans[2] = arr[idx];
				max = absSum;
			}

			if (sum > 0)
				right--;
			else
				left++;
		}

	}

}

//public class 백준_G3_2473_세용액 {
//	
//	static int N;
//	static int [] arr ;
//	static long [] selectedArr = new long[3];
//	static long [] ans = new long[4];
//	static boolean []  isSelected ;
//	public static void main(String[] args) throws IOException{
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st ;
//		StringBuilder sb = new StringBuilder();
//		
//		N = Integer.parseInt(br.readLine());
//		
//		arr = new int[N];
//		isSelected = new boolean[N];
//		
//		
//		st = new StringTokenizer(br.readLine());
//		
//		for(int i=0; i<N; i++) 
//		{
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		permutation(0);
//		
//		//Arrays.sort(ans);
//		long ans2[] = new long[3];
//		for(int i=0; i<3;i++) 
//		{
//			ans2[i]=ans[i];
//		}
//		
//		Arrays.sort(ans2);
//		
//		for(int i=0; i<3; i++) 
//		{
//			sb.append(ans2[i]).append(" ");
//		}
//		System.out.println(sb);
//		//System.out.println(ans[3]);
//		
//	}
//	
//	static long min = Long.MAX_VALUE;
//	
//	public static void permutation(int cnt) 
//	{
//		if(cnt==3) 
//		{
//			//System.out.println(Arrays.toString(selectedArr));
//			
//			long sum = selectedArr[0]+selectedArr[1]+selectedArr[2];
//			//min = Math.abs(min)
//			if(sum>0) {
//				if(Math.abs(sum)<min ) {
//					min =Math.abs(sum);
//					ans[0] = selectedArr[0];
//					ans[1] = selectedArr[1];
//					ans[2] = selectedArr[2];
//					ans[3]=min;
//				}
//			}
//			else if( sum<0) 
//			{
//				if(Math.abs(sum)<min ) {
//					min =Math.abs(sum);
//					ans[0] = selectedArr[0];
//					ans[1] = selectedArr[1];
//					ans[2] = selectedArr[2];
//					ans[3]=min;
//				}
//			}
//			else {
//				return;
//			}
//			
//			
//			return;
//		}
//		
//		for(int i=0;i<N; i++) 
//		{
//			if(isSelected[i])
//				continue;
//			
//			selectedArr[cnt]=arr[i];
//			isSelected[i]=true;
//			permutation(cnt+1);
//			isSelected[i]=false;
//		}
//	}
//
//}
