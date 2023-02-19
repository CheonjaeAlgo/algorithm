package _2월3주차;

import java.util.*;

import _2월3주차.BOJ_G4_24041_성싶당밀키트.Food;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/24041
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G4_24041_성싶당밀키트 {

	static class Food{
		long s;
		long l;
		long o;

		public Food(long s, long l, long o) {
			this.s = s;
			this.l = l;
			this.o = o;
		}


		@Override
		public String toString() {
			return "Food [s=" + s + ", l=" + l + ", o=" + o + "]";
		}
		
		
	}

	static int N, G, K;
	static long ans;
	static ArrayList<Food> arr = new ArrayList<Food>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken()); // 부패속도
			int L = Integer.parseInt(st.nextToken()); // 유통기한
			int O = Integer.parseInt(st.nextToken()); // 중요재료

			arr.add(new Food(S,L,O));
			// 세균수 S * max(1,구매후 x일 - Li)
		}
		
		
		long left =0; 
		long right = Integer.MAX_VALUE;
	
		
		while(left<=right) 
		{
			long mid = (left+right)/2;
			if(check(mid)) 
			{
				left=mid+1;
				ans =mid;
			}
			else 
			{
				right=mid-1;
			}
			
		}
		System.out.println(ans);
		
	}
	
	static boolean check(long mid) 
	{
		ArrayList<Long> total = new ArrayList<Long>();
		long sum =0;
		for(Food f : arr) 
		{
			
			long 세균 = f.s * Long.max(1L,mid-f.l);
			sum+=세균;
			if(f.o==1) 
			{
				total.add(f.s * Long.max(1L,mid-f.l));
			}
		}
		
		total.sort(Comparator.reverseOrder());
		for(int i = 0; i < Math.min(total.size(), K); i++) {
            sum -= total.get(i);
        }
		return sum<=G;
	}
	
	
}
