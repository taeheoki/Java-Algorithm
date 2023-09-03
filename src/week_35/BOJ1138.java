package src.week_35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ - 한 줄로 서기
 */
public class BOJ1138 {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        pro();
        StringBuilder sb = new StringBuilder();
        for (int num : dp) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static void pro() {
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = arr[i];
            int position = 0;
            for (int j = 0; j < N; j++) {
                if (tmp == 0 && dp[j] == 0)
                    break;
                if (dp[j] == 0)
                    tmp--;
                position++;
            }
            dp[position] = i + 1;
        }
    }
}
