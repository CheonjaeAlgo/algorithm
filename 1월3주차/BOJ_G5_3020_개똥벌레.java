import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3020
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G5_3020_개똥벌레 {

	static int N; // 동굴의 길이
	static int H; // 동굴의 높이
	static int 석순[];
	static int 종유석[];
	
	static int MIN=Integer.MAX_VALUE; //충돌할 때 걸리는 수

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		석순 = new int[N / 2];
		종유석 = new int[N / 2];
		int 뿌셔 =1;

		for (int i = 0; i < N / 2; i++) {
			석순[i] = Integer.parseInt(br.readLine());
			종유석[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(석순);
		Arrays.sort(종유석);


		for(int i=1; i<=H;i++) 
		{
			int 아래뿌셔 =binarySearch(0, N/2-1, 석순, i);
			int 위에뿌셔 =binarySearch(0, N/2-1, 종유석, H-i+1);
			
			
			if(MIN>아래뿌셔+위에뿌셔) {
				MIN=아래뿌셔+위에뿌셔;
				뿌셔=1;
			}
			else if(MIN==아래뿌셔+위에뿌셔) {
				뿌셔++;
			}
			
		}
		
		System.out.println(MIN+" "+뿌셔);

	}

	public static int binarySearch(int left, int right, int[]arr,int height)
	{
		int min= Integer.MAX_VALUE;
		
		while(left<=right) 
		{
			int mid=(left+right)/2;
			
			//만약 높이가 같거나 지금 높이보다 높으면
			if(arr[mid] >= height) 
			{
				min=Math.min(min, mid);
				right = mid-1;	
			}
			else {
				left =mid+1;
				}
		}
		
		int result =0;
		if(min==Integer.MAX_VALUE) 
		{
			return 0;
		}
		else 
		{
			return (N/2)-min;
		}
		
	}

}
