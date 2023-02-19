package _2월3주차;
import java.util.*;
import java.io.*;
/**
 * https://www.acmicpc.net/problem/10825
 * @author Zizon_Yonni
 *
 */
public class BOJ_S4_10825_국영수 {

	static String arr[][];
	static int N;
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
	        N = Integer.parseInt(br.readLine());

	        arr = new String[N][4];
	        for(int i=0;i<N;i++){
	            StringTokenizer st = new StringTokenizer(br.readLine());

	            arr[i][0] = st.nextToken();
	            arr[i][1] = st.nextToken();
	            arr[i][2] = st.nextToken();
	            arr[i][3] = st.nextToken();

	        }
	        
	        Arrays.sort(arr,new Comparator<String[]>(){
	            @Override
	            public int compare(String[] o1, String[] o2){
	                if(o2[1].equals(o1[1])){
	                    if(o1[2].equals(o2[2])){
	                        if(o1[3].equals(o2[3])){
	                            return o1[0].compareTo(o2[0]);
	                        }
	                        return Integer.parseInt(o2[3])-Integer.parseInt(o1[3]);
	                    }

	                    return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);

	                }
	                return Integer.parseInt(o2[1])- Integer.parseInt(o1[1]);
	            }
	        });
	        
	        for(int i=0;i<arr.length;i++){
	            sb.append(arr[i][0]).append("\n");
	        }
	        System.out.println(sb);
	}

}
