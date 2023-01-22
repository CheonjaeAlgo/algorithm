import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2110
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G4_2110_공유기설치 {

	static int N; // 집의 개수
	static int C; // 공유기의 개수
	static int[] position; // 집 좌표

	static int result ; // 가장 인접한 두 공유기 사이의 최대가 되는 거리

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		position = new int[N];

		for (int i = 0; i < N; i++) {
			position[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(position); // 이분 검색을 위한 sort

		
		int start=1;	// 최소거리가 가질 수 있는 최소값
		int end = position[N-1]-position[0];	// 최소 거리가 가질 수 있는 최대값
		
		while(start <= end) 
		{
			
			int mid = (start + end)/2;
			int left = position[0];
			int 공유기 = 1;
			
			for (int i=1; i<N; i++) {
                if (position[i]-left>=mid) {
                   
                	공유기++;
                    left = position[i];
                }
            }
			
			 if (공유기>=C) {
	                //실제 설치될 공유기보다 많이 설치함 -> 오른쪽으로 이동해 더 긴 간격 찾아야함
	                result = mid;
	                start = mid+1;
	            } else {
	                //공유기를 c보다 적게 설치함 -> 왼쪽으로 이동해 더 짧은 간격 찾아야함
	                end = mid-1;
	            }
		}
		
		System.out.println(result);
		
	}

}
