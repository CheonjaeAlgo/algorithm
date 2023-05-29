package _5월4주차;
import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2559
 * 
 * @author Zizon_Yonni
 *
 */
public class 백준_S3_2559_수열 {

	static int N,K;
	static long arr [],sumArr[];
	static long sum;
	static long max = Long.MIN_VALUE;
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1 ;i++) 
		{
			arr[i] = arr[i-1] +Integer.parseInt(st.nextToken());
			
		}
		
		for(int i=K;i<N+1;i++) 
		{
			long sum = arr[i]-arr[i-K];
			
			max = Long.max(sum,max);
		}
		
		System.out.println(max);
	}

}
