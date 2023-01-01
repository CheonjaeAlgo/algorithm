package _12_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9207
 * 
 * @author Zizon_Yonni 첫번째 : X / 두번째 : O
 * 
 *         게임이 종료하는 경우의 수 1) X가 이길 경우 2) O가 이길 경우 3) 게임판이 꽉 찼을 때 4) 개판일 때 (x보다
 *         o가 더 많을 경우)
 * 
 *         (게임판이 ) //뭐이딴 개같은 ㅁ누제가 다있음 가능할 경우 valid 불가능할 경우 invalid
 *
 *         조건 1) OX갯수 세기 -> X의 개수 = O의 개수+1 | O의 갯수 2) 누가 승리 했냠 -> X또는 O 둘중하나 승리
 *         << 승리조건 >> (1) 가로 123, 456,789 (2) 세로 147, 258, 369 (3) 대각선 159, 357
 *         3) 둘 다 승리하지 않았다면 -> 꽉찬 게임판
 * 
 */

public class BOJ_G5_7682_틱택토 {

	static int cntX, cntO;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean condition1, condition2, condition3 = false;

		while (true) {
			String input = br.readLine();

			if (input.equals("end"))
				break;

			if (check_condition1(input) == false) {
				sb.append("invalid\n");
			} else {
				if (check_condition2(input)) {
					sb.append("valid\n");
				} else {
					sb.append("invalid\n");
				}
			}

		}
		System.out.println(sb);
	}

	public static boolean check_condition1(String input) {
		cntX = 0;
		cntO = 0;

		for (int i = 0; i < 9; i++) {
			char ch = input.charAt(i);

			if (ch == 'X')
				cntX++;
			else if (ch == 'O')
				cntO++;
		}

		if (cntX == cntO)
			return true;
		else if (cntX - cntO == 1)
			return true;

		else
			return false;
	}

	/**
	 * 2) 누가 승리 했냠 -> X또는 O 둘중하나 승리 << 승리조건 >> (1) 가로 123, 456,789 (2) 세로 147, 258,
	 * 369 (3) 대각선 159, 357
	 */
	public static boolean check_condition2(String input) {

		int winX = 0;
		int winO = 0;

		// 가로
		for (int i = 0; i < 9; i += 3) {
			if (input.charAt(i) == '.')
				continue;
			if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i + 1) == input.charAt(i + 2)) {
				if (input.charAt(i) == 'X')
					winX++;
				else
					winO++;
			}
		}

		// 세로
		for (int j = 0; j < 3; j++) {
			if (input.charAt(j) == '.')
				continue;
			if (input.charAt(j) == input.charAt(j + 3) && input.charAt(j + 3) == input.charAt(j + 6)) {
				if (input.charAt(j) == 'X')
					winX++;
				else
					winO++;
			}
		}

		// 대각선
		if (input.charAt(4) != '.') {
			if ((input.charAt(4) == input.charAt(0) && input.charAt(4) == input.charAt(8))
					|| (input.charAt(4) == input.charAt(2) && input.charAt(4) == input.charAt(6))) {
				if (input.charAt(4) == 'X')
					winX++;
				else
					winO++;
			}
		}

		if (winX > 0) {
			if (winO > 0)
				return false;
			if (cntX - cntO == 1)
				return true;
			else
				return false;
		}
		if (winO > 0) {
			if (cntX - cntO == 0)
				return true;
			else
				return false;
		}
		if (cntX + cntO == 9)
			return true;
		return false;

	}
}

/*
 * (1) invalid 번갈아서 해야되는데 O가 적음 XXX OO. XXX
 * 
 * (2) valid XOXOXOXOX
 * 
 * XOX OXO XOX
 * 
 * (3) invalid O의 갯수가 더많음 OXOXOXOXO
 * 
 * OXO XOX OXO
 * 
 * (4) valid XXOOOXXOX
 * 
 * XXO OOX XOX
 * 
 * (5) valid XO.OX...X
 * 
 * XO. OX. ..X
 * 
 * (6) invalid O의 승리조건 겜 종료되야댐 .XX X.X OOO
 * 
 * (7) invalid 아무도 승리하지 않음. X.O O.. X..
 * 
 * (8) invalid O갯수가 더많음 OOX XXO OXO end
 *
 * 
 */
