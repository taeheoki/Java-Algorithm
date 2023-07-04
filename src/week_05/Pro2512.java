package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2512번 예산
 * 시간 복잡도: O(N * log(right) + log(N))
 */
public class Pro2512 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int res = 0;
        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getSum(mid) <= M) {
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
            sum += (arr[i] <= mid) ? arr[i] : mid;
        }
        return sum;
    }
}