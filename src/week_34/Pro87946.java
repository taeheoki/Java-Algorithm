package src.week_34;

/**
 * 프로그래머스 - 피로도
 */
public class Pro87946 {

    static int n, res;
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    public static int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        arr = dungeons;
        visit = new boolean[n];
        rec_func(0, k);
        return res;
    }

    private static void rec_func(int depth, int k) {
        res = Math.max(res, depth);
        for (int i = 0; i < n; i++) {
            if (visit[i])
                continue;
            if (arr[i][0] > k)
                continue;
            visit[i] = true;
            rec_func(depth + 1, k - arr[i][1]);
            visit[i] = false;
        }
    }
}
