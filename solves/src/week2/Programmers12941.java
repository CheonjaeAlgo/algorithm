package week2;

import java.util.Arrays;

public class Programmers12941 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < n; i++) {
            answer += A[i] * B[n - 1 - i];
        }
        return answer;
    }
}
