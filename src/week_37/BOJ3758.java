package src.week_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 3758 - KCPC
 */
public class BOJ3758 {
    static int T, n, k, t, m, i, j, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            for (int log = 0; log < m; log++) {
                st = new StringTokenizer(br.readLine());
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
            }
        }
    }
}
