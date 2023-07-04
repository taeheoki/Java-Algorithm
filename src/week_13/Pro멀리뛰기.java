package src.week_13;

/**
 * 프로그래머스 - 멀리 뛰기
 * 문제 이해: 효진이가 멀리 뛰기를 연습하고 있는데, 한번에 1칸 또는 2칸을 뛸 수 있다.
 *          그렇다면 목적지까지 도달할 수 있는 경우의 수는 얼마인가?
 * 시간 복잡도: BruteForce로 구한다.
 *           처음에 bruteForce로 풀면 될 줄 알았는데, 생각해보니 시간초과가 많았고, 고민해보니
 *           i - 1, i - 2 까지 가는 방법을 이용하는 DP 문제라는 생각이 들었다.
 */
public class Pro멀리뛰기 {
    static int[] dp;

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }

    public static long solution(int n) {
        pro(n);
        return dp[n];
    }

    private static void pro(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2)
            dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
    }
}
