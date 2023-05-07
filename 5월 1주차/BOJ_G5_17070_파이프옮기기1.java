package 풀기싫어서죽겟네;

import java.io.*;
import java.util.*;

public class BOJ_G5_17070_파이프옮기기1 {

	static int N, ans;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        ans = 0;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 1, 0);

        System.out.println(ans);
    }


    // State = 0가로 , 1세로, 2 대각선
    static void DFS(int x, int y, int state) {
        if (x == N - 1 && y == N - 1) {
            ans++;
            return;
        }

        if(state == 0){
            if(y+1 < N && matrix[x][y+1] == 0){
                DFS(x, y + 1, 0);
            }
        }else if(state == 1){
            if(x+1 < N && matrix[x+1][y] == 0){
                DFS(x+1, y, 1);
            }
        }else if(state == 2){
            if(y+1 < N && matrix[x][y+1] == 0){
                DFS(x, y + 1, 0);
            }
            if(x+1 < N && matrix[x+1][y] == 0){
                DFS(x+1, y , 1);
            }
        }

        if (x + 1 < N && y + 1 < N && matrix[x][y + 1] == 0 && matrix[x + 1][y] == 0 && matrix[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }

    }

}
