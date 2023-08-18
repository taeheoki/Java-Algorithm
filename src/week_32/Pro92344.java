package src.week_32;

/**
 * 프로그래머스 - 파괴되지 않은 건물
 */
public class Pro92344 {
    static int res;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
    }


    public static int solution(int[][] board, int[][] skill) {
        int[][] skillMap = new int[board.length][board[0].length];
        for (int[] ints : skill) {
            int type = ints[0];
            int r1 = ints[1];
            int c1 = ints[2];
            int r2 = ints[3];
            int c2 = ints[4];
            int degree = ints[5];
            if (type == 1)
                degree *= -1;
            skillMap[r1][c1] += degree;
            if (r2 + 1 < board.length)
                skillMap[r2 + 1][c1] -= degree;
            if (c2 + 1 < board[0].length)
                skillMap[r1][c2 + 1] -= degree;
            if (r2 + 1 < board.length && c2 + 1 < board[0].length)
                skillMap[r2 + 1][c2 + 1] += degree;

        }

        // 누적합 실행
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                skillMap[i][j] += skillMap[i][j - 1];
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 1; j < board.length; j++) {
                skillMap[j][i] += skillMap[j - 1][i];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(skillMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        return res;
    }
}
