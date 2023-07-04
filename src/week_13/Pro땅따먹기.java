package src.week_13;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 프로그래머스 - 땅따먹기
 * 문제 이해: N행 4열로 이루어진 땅이 있을 때, 모든 칸에 점수가 쓰여 있다.
 *          각 행마다 한 칸을 밟으면서 내려올 때, 같은 열을 연속해서 밟을 수 없다는 규칙이 존재한다.
 *          마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 출력하라.
 *          DP 문제
 */
public class Pro땅따먹기 {
    static int dp[][];
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }

    private static int solution(int[][] land) {
        dp = new int[land.length][land[0].length];
        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k)
                        continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                }
            }
        }

        return Arrays.stream(dp[land.length - 1]).max().getAsInt();
    }
}
