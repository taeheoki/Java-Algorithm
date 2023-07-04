package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2018 - 수들의 합 5
 * 문제 이해: 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
 *          N을 만드는 자연수의 합의 가지수를 알 고 싶다.
 * 시간 복잡도: O(2 * N) -> O(N)
 */
public class Pro2018 {
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        int right = 0;
        int sum = 0;
        for (int left = 1; left <= N; left++) {
            sum -= left - 1;
            while (sum < N && right + 1 <= N) {
                right++;
                sum += right;
            }
            if (sum == N)
                cnt++;
        }
        System.out.println(cnt);
    }
}
