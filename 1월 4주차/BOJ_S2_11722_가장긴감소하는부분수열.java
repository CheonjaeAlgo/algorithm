package _1월4주차;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11722
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_S2_11722_가장긴감소하는부분수열 {
	static int N;
	static int arr[];
	static int dp[];
	static int ans = 1;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		dp[0]=1; // 자신이 첫번째 원소가 되어 길이가.된다? 
		
		for (int i = 1; i < N; i++) {
			dp[i]=1;
			for(int j=0; j<i;j++) 
			{
				if(arr[j]>arr[i]) 
				{
					dp[i]=Integer.max(dp[i],dp[j]+1);
				}
			}
			ans= Integer.max(ans,dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(ans);
	}

}
