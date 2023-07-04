package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2292 - 벌집
 * 문제 이해: 1 -> 7 -> 19 -> 37 -> 61
 *            6    12    18   24
 */
public class Pro2292 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        int start = 1;
        int i = 0;
        while (true) {
            start += 6 * i;
            if (start >= N)
                break;
            i++;
        }
        System.out.println(i + 1);
    }
}
