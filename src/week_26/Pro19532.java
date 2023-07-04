package src.week_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 19532 - 수학은 비대면강의입니다
 */
public class Pro19532 {
    static int a, b, c, d, e, f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.println(x + " " + y);
                    System.exit(0);
                }
            }
        }
    }
}
