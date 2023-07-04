package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2231 - 분해합
 */
public class Pro2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = i;
            int sum = tmp;
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum == N) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}
