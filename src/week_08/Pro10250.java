package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 10250 - ACM 호텔
 * 문제 이해:
 */
public class Pro10250 {
    static StringBuilder sb = new StringBuilder();
    static int T, H, W, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        int cnt = 0;
        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= H; j++) {
                cnt++;
                if (cnt == N) {
                    sb.append(j);
                    if (i < 10)
                        sb.append("0");
                    sb.append(i).append("\n");
                }
            }
        }
    }
}
