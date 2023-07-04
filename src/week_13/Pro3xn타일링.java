package src.week_13;

/**
 * 프로그래머스 - 3 x n 타일링
 */
public class Pro3xn타일링 {
    static long[] dp;

    public static void main(String[] args) {
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        if (n >= 2)
            dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 1)
                dp[i] = 0;
            else {
                dp[i] = dp[i - 2] * dp[2];
                for (int j = 4; j <= i; j += 2)
                    dp[i] = (dp[i] + dp[i - j] * 2) % 1000000007;
            }
        }
        return (int) dp[n];
    }
}
