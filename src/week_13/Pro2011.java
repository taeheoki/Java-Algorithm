package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * BOJ 2011 - 암호코드
 * 문제 이해: 글자와 숫자를 매칭하고, 글자를 통해 숫자를 유추할 때, 가능한 숫자는 몇개가 나오는지 알아보자.
 */
public class Pro2011 {
    public static final int MOD = 1000000;
    static String numStr;
    static int[] dp, pre;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numStr = br.readLine();
        pro();
    }

    private static void pro() {
        dp = new int[numStr.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= numStr.length(); i++) {
            int cur = numStr.charAt(i - 1) - '0';
            if (cur >= 1 && cur <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }
            if (i == 1)
                continue;
            int prev = numStr.charAt(i - 2) - '0';
            if (prev == 0)
                continue;
            int value = prev * 10 + cur;
            if (value >= 10 && value <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[numStr.length()]);
    }

}
