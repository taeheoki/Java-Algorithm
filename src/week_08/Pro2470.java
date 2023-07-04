package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2470 - 두 용액
 */
public class Pro2470 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        // A 에 대해 이분 탐색을 할 예정이니까, 정렬을 미리 해주자.
        Arrays.sort(arr, 1, N + 1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, L = 1, R = N;

        while (L < R) { // L ==  R 인 상황이면 용액이 한 개 뿐인 것이므로, L < R 일 때까지만 반복한다.
            int sum = arr[L] + arr[R];
            if (Math.abs(sum) < best_sum) {
                best_sum = Math.abs(sum);
                v1 = arr[L];
                v2 = arr[R];
            }
            if (sum > 0)
                R--;
            else
                L++;
        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }
}
