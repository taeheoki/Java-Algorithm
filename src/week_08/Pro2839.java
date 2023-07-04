package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2839 - 설탕 배달
 */
public class Pro2839 {
    static final int threeKG = 3;
    static final int fiveKG = 5;

    static int N, res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        boolean flag = false;
        for (int i = 0; i <= N / fiveKG; i++) {
            if (((N - i * fiveKG) % threeKG) == 0) {
                int tmp = i + (N - i *fiveKG) / threeKG;
                res = Math.min(res, tmp);
                flag = true;
            }
        }
        System.out.println(flag ? res : -1);
    }
}
