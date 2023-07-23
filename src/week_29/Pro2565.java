package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ 2565 - 전깃줄
 */
public class Pro2565 {
    static int n;
    static int[][] wire;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wire = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            wire[i][0] = a;
            wire[i][1] = b;
        }
        pro();
    }

    private static void pro() {
        dp = new Integer[n];
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, rec_func(i));
        }
        System.out.println(n - max);
    }

    private static int rec_func(int N) {

        // 탐색하지 않았던 위치라면
        if (dp[N] == null) {
            dp[N] = 1; // 최솟값 1로 초기화

            // A의 N 번째와 이후의 전봇대들 비교
            for (int i = N + 1; i < dp.length; i++) {
                /**
                 * A 전봇대의 N번째 전선이 연결되어 있는 B 전봇대보다 A의 i번째
                 * 전봇대의 전선이 이어진 B 전봇대가 뒤에 있을 경우
                 * 전성을 설치할 수 있음
                 */
                if (wire[N][1] < wire[i][1]) {
                    // 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장한다.
                    dp[N] = Math.max(dp[N], rec_func(i) + 1);
                }
            }
        }
        return dp[N];
    }
}
