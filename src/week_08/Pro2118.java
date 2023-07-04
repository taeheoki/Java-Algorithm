package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * BOJ 2118 - 두 개의 탑
 * 문제 이해: 원형으로 이루어진 지점 중 두 지점에 탑을 세울텐데, 두 지점 사이의 거리를 잴 때 값 중 더 작은 값을 거리로
 *          두 지점 사이의 거리의 최댓값을 계산해보자.
 * 시간 복잡도: O(2 * N) -> O(N)
 */
public class Pro2118 {
    static int N, res = Integer.MIN_VALUE, total;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        pro();
    }

    private static void pro() {
        int right = 0;
        int sum = 0;
        for (int left = 1; left <= N; left++) {
            sum -= arr[left - 1];
            while (sum < total - sum && right + 1 <= N) {
                right++;
                sum += arr[right];
            }
            if (sum > total - sum) {
                sum -= arr[right];
                right--;
            }
            int tmp = Math.min(sum, total - sum);
            res = Math.max(res, tmp);
        }
        System.out.println(res);
    }
}

