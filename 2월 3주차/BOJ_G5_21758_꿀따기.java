package _2월3주차;
import java.util.*;
import java.io.*;
/**
 * https://www.acmicpc.net/problem/21758
 * @author Zizon_Yonni
 *
 */
public class BOJ_G5_21758_꿀따기 {

	static int N, index, max;
	static int arr[];
	static int sumRight[];
	static int sumLeft[],sum[];
	static int ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sumRight = new int[N];
		sumLeft = new int[N];
		sum=new int[N];

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		sumRight[0]=arr[0];
		sumLeft[0]=arr[N-1];
		
		for (int i = 1; i < N; i++) {
			sumRight[i]=sumRight[i-1]+arr[i];
			sumLeft[i]=sumLeft[i-1]+arr[N-1-i];
		}

		ans=0;
		for(int i=0;i<N;i++) 
		{
			int sum =0;
			if(i==N-1) 
			{
				for (int j = 1; j < N-1; j++) {
					sum= sumRight[N-1]-sumRight[0]+sumRight[N-1]-sumRight[j]-arr[j];
					ans = Integer.max(ans, sum);
				}
			}
			else if(i==0) {
			
				for (int j = 1; j < N-1; j++) {
					sum= sumLeft[N-1]-sumLeft[0]+sumLeft[N-1]-sumLeft[j]-arr[N-1-j];
					System.out.println(sum);
					ans = Integer.max(ans, sum);
				}
			}
			else 
			{
				sum = sumRight[i]-sumRight[0]+sumLeft[N-1-i]-sumLeft[0];
				ans = Integer.max(ans, sum);
			}
		}
		
		
		
		
		
		System.out.println(ans);
	
//		System.out.println(Arrays.toString(sumRight));
//		System.out.println(Arrays.toString(sumLeft));
//		System.out.println(index);
	}
}
