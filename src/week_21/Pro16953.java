package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 16953 - A → B
 */
public class Pro16953 {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        int cnt = 1;
        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
                cnt++;
            } else if (B % 10 == 1) {
                B = (B - 1) / 10;
                cnt++;
            } else
                break;
        }
        System.out.println(B == A ? cnt : -1);
    }
}
