package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 17951 - 흩날리는 시험지 속에서 내 평점이 느껴진거야
 */
public class Pro17951 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += arr[i];
                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }

            if (cnt > K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left - 1);
    }
}
