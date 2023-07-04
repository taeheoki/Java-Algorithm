package src.week_13;

/**
 * 프로그래머스 - 가장 큰 정사각형 찾기
 */
public class Pro가장큰정사각형찾기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
//        res = 0;
//        cnt = 0;
        System.out.println(solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
//        res = 0;
//        cnt = 0;
        System.out.println(solution(new int[][]{{0}, {0}}));
        System.out.println(solution(new int[][]{{1}, {1}}));
    }

    public static int solution(int [][]board) {
        int[][] dp = new int[board.length + 1][board[0].length + 1];
        int res = 0;
        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                if (board[i - 1][j - 1] == 1)
                    dp[i][j] = 1;
            }
        }
        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                if (board[i - 1][j - 1] == 0)
                    continue;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
