package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1007
 * @author Zizon_Yonni
 *
 */
public class BOJ_1007_G2_벡터매칭 {

	public static class Point 
	{
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		
	}
	
	static int T ;
	static int N ;
	static double MIN = Double.MAX_VALUE;
	static Point points [] ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N= Integer.parseInt(br.readLine());
			
			points= new Point[N];
			isChecked = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				points[i]= new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				
			}
			
			combination(0, N / 2);
			
			System.out.println(MIN);
		}
	}
	
	private static double Vector()
    {
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < N; i++)
        {
            if (isChecked[i])
            {
                x += points[i].x;
                y += points[i].y;
            }
            
            else
            {
                x -= points[i].x;
                y -= points[i].y;
            }
        }
        
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

	public static boolean[] isChecked;
	public static void combination(int index, int count)
    {
        if (count == 0)
        {
            MIN = Math.min(MIN, Vector());
        }
        
        // 조합할 원소 갯수가 아직 남아있을 경우
        else
        {
            for (int i = index; i < N; i++)
            {
                isChecked[i] = true;
                
                combination(i + 1, count - 1);
                
                isChecked[i] = false;
            }
        }
    }
}
