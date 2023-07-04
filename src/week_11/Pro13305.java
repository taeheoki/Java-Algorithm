package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 13305 - 주유소
 * 문제 이해:
 */
public class Pro13305 {
    static int N;
    static long[] dist, price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new long[N];
        price = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        long sum = 0;
        long pivot = price[0];
        for (int i = 0; i < N; i++) {
            if (pivot <= price[i]) {
                sum += dist[i] * pivot;
            } else {
                pivot = price[i];
                sum += dist[i] * pivot;
            }
        }
        System.out.println(sum);
    }
}
