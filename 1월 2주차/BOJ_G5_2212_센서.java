import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2212
 * 
 * @author Zizon_Yonni
 *
 */
public class BOJ_G5_2212_센서 {

	static int N; // 센서의 갯수
	static int K; // 집중국의 갯수
	static int[] sensor; // 센서의 좌표
	static int[] sensorDistance; // 센서간의 거리

	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		sensor = new int[N];
		sensorDistance = new int[N - 1];

		st = new StringTokenizer(br.readLine());

		// 센서 입력값 배열 sensor에 저장
		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}

		// 센서간의 거리 오름차순
		Arrays.sort(sensor);

		for (int i = 0; i < N - 1; i++) {
			sensorDistance[i] = sensor[i + 1] - sensor[i];
		}

		Arrays.sort(sensorDistance);

		for (int i = 0; i < N - K; i++) {
			result +=sensorDistance[i];
		}
		
		System.out.println(result);

	}

}
