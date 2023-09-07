package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 17140 - 이차원 배열과 연산
 */
public class BOJ17140 {
    static final int BOARD_SIZE = 3;
    static int r, c, k;
    static int[][] board = new int[3][3], tmpBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < BOARD_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro(); 
    }

    private static void pro() {
        int cnt = 0;
        while (true) {
            if (board.length > r && board[0].length > c && board[r][c] == k)
                break;
            if (board.length >= board[0].length) {
                
            } else {

            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
