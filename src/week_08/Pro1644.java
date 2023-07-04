package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1644 - 소수의 연속합
 * 문제 이해: 주어 진 N을 연속된 소수의 합으로 만들어 낼수 있는 경우의 수를 구하라.
 *          문제 자체가 어렵다기 보다, 먼저 주어진 수보다 낮은 소수의 집합을 구하고,
 *          이후 문제를 풀어내는 거라 2가지 개념이 섞인 느낌이다.
 * 시간 복잡도: O(에라토스테네스의 체(N 이하의 소수 구하기) + N(투 토인터))
 */
public class Pro1644 {
    static int N, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        arr = new int[N + 1];
        // 초기화
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        // 2부터 시작해서 특정 수의 배수에 해당하는 수를 지운다.
        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0)
                continue;
            for (int j = i * 2; j <= N; j += i) {
                arr[j] = 0;
            }
        }
        int right = 1;
        int sum = 1;
        for (int left = 2; left <= N; left++) {
            sum -= arr[left - 1];
            if (arr[left - 1] == 0)
                continue;
            while (sum < N && right + 1 <= N) {
                right++;
                sum += arr[right];
            }
            if (sum == N)
                cnt++;
        }
        System.out.println(cnt);
    }
}
