package src.week_32;

/**
 * 프로그래머스 - 카드 짝 맞추기
 */
public class Pro72415 {

    static int res;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {

    }

    public static int solution(int[][] board, int r, int c) {
        rec_func(board, r, c, 0);
        return res;
    }

    private static void rec_func(int[][] board, int r, int c, int num) {
        for (int[] dir : dirs) {

        }
    }
}
