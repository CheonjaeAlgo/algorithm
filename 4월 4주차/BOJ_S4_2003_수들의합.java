package 풀기싫어서죽겟네;
import java.io.*;
import java.util.*;


public class BOJ_S4_2003_수들의합 {

	static int N,M;
	static int num [];
	static int ans;
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i]= Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N;i++) 
		{
			int sum =0;
			for(int j=i; j<N;j++) 
			{
				sum+=num[j];
				if(sum==M) 
				{
					ans++;
					break;
				}else if(sum>M) 
				{
					break;
				}
			}
		}
		
		System.out.println(ans);
	}

}
