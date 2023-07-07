package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1456 - 거의 소수
 */
public class Pro1456 {
    static long A, B;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        pro();
    }

    private static void pro() {
        arr = new boolean[10000000 + 1];
        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (arr[i])
                continue;
            for (int j = i * 2; j <= Math.sqrt(B); j += i) {
                arr[j] = true;
            }
        }

        int cnt = 0;
        for (int i = 2; i <= 10000000; i++) {
            if (i >= B)
                break;
            if (arr[i])
                continue;
            for (int j = 2; ; j++) {
                if ((long) Math.pow(i, j) > B)
                    break;
                if ((long) Math.pow(i, j) < A)
                    continue;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
