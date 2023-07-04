package src.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 21941 - 문자열 제거
 */
public class Pro21941 {
    static String data;
    static int M, ans;
    static int[] dp;
    static ArrayList<Elem> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        data = br.readLine();
        ans = data.length();
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            arr.add(new Elem(str, score));
        }
        pro();
        System.out.println(dp[data.length()]);
    }

    private static void pro() {
        dp = new int[data.length() + 1];
        for (int i = 0; i < data.length(); i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i] + 1);
            for (Elem e : arr) {
                String tmp = e.str;
                if (data.startsWith(tmp, i)) {
                    dp[i + tmp.length()] = Math.max(dp[i + tmp.length()], dp[i] + e.score);
                }
            }
        }
    }

    private static class Elem {
        String str;
        int score;

        public Elem(String str, int score) {
            this.str = str;
            this.score = score;
        }
    }
}
