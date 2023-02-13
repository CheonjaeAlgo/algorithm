package _2월3주차;
import java.util.*;
import java.io.*;
/**
 * https://www.acmicpc.net/problem/1654
 * @author Zizon_Yonni
 *
 */

public class BOJ_S2_1654_랜선자르기 {
	static int K,N;// 랜선의 개수, 필요한 랜선
	static int arr[];
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		
		for (int i = 0; i < K; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long size =0;
		long left =1;
		long right = arr[K-1];
		
		while(left<=right) 
		{
			long mid = (left+right)/2;
//			System.out.println("높이 : "+size+" left : "+left+" right : "+right);
//			System.out.println(mid);
			if(check(mid)) 
			{
				size= mid;
				left=mid+1;
			}else 
			{
				right=mid-1;
			}
		}
		
		System.out.println(size);
		
	}

	public static boolean check(long h) 
	{
		long sum =0;
		long cnt=0;
		
		for (int i = 0; i < K; i++) {
			if(arr[i]>=h)
				cnt+= arr[i]/h;
		}
		return cnt>=N;
	}
	
}
