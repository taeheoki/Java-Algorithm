package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1166 - 선물
 */
public class Pro1166 {
    static int N, L, W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        double left = 0;
        double right = Math.min(L, Math.min(W, H));
        double res = 0;
        for (int i = 0; i < 5000; i++) {
            double mid = (left + right) / 2;
            if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) >= N) {
                res = mid;
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(res);
    }
}
