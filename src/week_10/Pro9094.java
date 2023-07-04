package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 9094 - 수학적 호기심
 */
public class Pro9094 {
    static StringBuilder sb = new StringBuilder();
    static int T, n, m, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        res = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                double tmp = ((double) j * j + i * i + m) / (j * i);
                if (tmp == (int) tmp)
                    res++;
            }
        }
        sb.append(res).append("\n");
    }
}
