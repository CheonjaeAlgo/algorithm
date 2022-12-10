package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
/**
 * https://www.acmicpc.net/problem/2212
 * @author Zizon_Yonni
 *
 */
public class BOJ_2212_G5_센서 {

	static int N,K;
	static int sum;
	static int MIN = Integer.MAX_VALUE;
	static int [] position;
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N= Integer.parseInt(br.readLine());
		K= Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			position[i] = Integer.parseInt(st.nextToken());
		}
			if(K>=N) 
			{
				return;
			}
			
			Arrays.sort(position);
			
			int [] dif = new int[N-1];
			
			for (int i = 0; i < N-1; i++) {
				dif[i] =position[i+1]-position[i];
			}
			
			Arrays.sort(dif);
			
			for (int i = 0; i < dif.length-K+1; i++) {
				sum+=dif[i];
			}
			
			System.out.println(sum);
			
		
		
	}
}
