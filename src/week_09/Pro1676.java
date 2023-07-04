package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1676 - 팩토리얼 0의 개수
 */
public class Pro1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = countZero(N);
        System.out.println(cnt);
    }

    private static int countZero(int n) {
        int cnt = 0;
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
            while (res % 10 == 0) {
                cnt++;
                res /= 10;
            }
            res %= 1000000000; // 결과 값이 커지면서 오버플로우 방지
        }
        return cnt;
    }
}