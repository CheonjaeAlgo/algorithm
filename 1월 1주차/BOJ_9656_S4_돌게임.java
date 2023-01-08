import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9656_S4_돌게임 {
	static int N ;
	static String result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		result = (N % 2 == 0) ? "SK" : "CY";
		System.out.println(result);

	}

}
