package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7983
 * @author Zizon_Yonni
 *
 */
public class BOJ_G5_7983_내일할거야 {
	
	static int N;
	static int homework[][];
	static int MIN = Integer.MAX_VALUE;
	public static void main(String [] args) throws  IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		
		homework = new int [N][2];
		
		for (int t = 0; t < N; t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			homework[t][0]=Integer.parseInt(st.nextToken());
			homework[t][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(homework,(o1,o2)->{
			return -Integer.compare(o1[1],o2[1]);
		});
		
		System.out.println(Arrays.deepToString(homework));

		for (int t = 0; t < N; t++) {
			MIN=Integer.min(homework[t][1],MIN)- homework[t][0];
		}
		
		System.out.println(MIN);
		
	}
	

}
