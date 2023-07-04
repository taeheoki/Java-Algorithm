package src.week_14;

/**
 * 프로그래머스 - N-Queen
 * 문제 이해: 체스판 위에 n개의 퀸이 서로 공격을 할 수 없도록 배치하려고 할 때,
 *         배치할 수 있는 경우의 수
 *         백트랙킹
 */
public class ProN_Queen {
    static int cnt;
    static boolean[][] arr;

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        arr = new boolean[n][n];
        rec_func(0, n);
        return cnt;
    }

    private static void rec_func(int depth, int n) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("\n");
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (validation(depth, i, n))
                continue;
            arr[depth][i] = true;
            rec_func(depth + 1, n);
            arr[depth][i] = false;
        }
    }

    private static boolean validation(int depth, int cmp, int n) {
        for (int i = 1; i <= depth; i++) {
            if (cmp - i >= 0 && arr[depth - i][cmp - i])
                return true;
            if (cmp + i < n && arr[depth - i][cmp + i])
                return true;
            if (arr[depth -i][cmp])
                return true;
        }
        return false;
    }
}
