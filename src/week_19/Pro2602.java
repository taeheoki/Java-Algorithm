package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2602 - 돌다리 건너기
 */
public class Pro2602 {
    static String cmps, devil, angel;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cmps = br.readLine();
        devil = br.readLine(); // 0
        angel = br.readLine(); // 1
        pro();
    }

    private static void pro() {
        dp = new int[cmps.length()][devil.length()][2];

        for (int i = 0; i < devil.length(); i++) {
            char cmp = cmps.charAt(0);
            if (devil.charAt(i) == cmp)
                dp[0][i][0] = 1;
            if (angel.charAt(i) == cmp)
                dp[0][i][1] = 1;
        }

        for (int i = 1; i < cmps.length(); i++) {
            char cmp = cmps.charAt(i);
            for (int j = i; j < devil.length(); j++) {
                if (devil.charAt(j) == cmp) {
                    for (int k = 0; k < j; k++) {
                        dp[i][j][0] += dp[i - 1][k][1];
                    }
                }
                if (angel.charAt(j) == cmp) {
                    for (int k = 0; k < j; k++) {
                        dp[i][j][1] += dp[i - 1][k][0];
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < devil.length(); i++) {
            sum += dp[cmps.length() - 1][i][0] + dp[cmps.length() - 1][i][1];
        }
        System.out.println(sum);
    }
}
