package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1920 - 수 찾기
 */
public class Pro1920 {
    static StringBuilder sb = new StringBuilder();
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
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            pro(tmp);
        }
        System.out.println(sb);
    }

    private static void pro(int tmp) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == tmp) {
                sb.append("1").append('\n');
                return;
            }
            if (arr[mid] >= tmp) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        sb.append("0").append('\n');
    }
}
