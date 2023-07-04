package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2512 - 예산
 * 문제 이해: 정해진 예산의 상한액을 설정하여 전체의 합이 최대가 될 때의
 *          예산 상한액은 얼마인가?
 */
public class Pro2512 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt();
        int res = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = getSum(mid);
            if (tmp <= M) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(res);
    }

    private static int getSum(int mid) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > mid) {
                sum += mid;
                continue;
            }
            sum += arr[i];
        }
        return sum;
    }
}
