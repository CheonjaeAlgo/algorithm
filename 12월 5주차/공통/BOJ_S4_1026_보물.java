package _12_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1026
 * @author Zizon_Yonni
 *
 */
public class BOJ_S4_1026_보물 {

	static int  B[];
	static Integer A[];
	static int N,result;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N= Integer.parseInt(br.readLine());
		
		A = new Integer[N];
		B = new int[N];
		
		st= new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			
			A[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A,Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			
			B[i]= Integer.parseInt(st.nextToken());
		}

		Arrays.sort(B);
		
		for (int i = 0; i < N; i++) {
			result+= A[i] * B[i];
		}
		
		System.out.println(result);
	}

}
