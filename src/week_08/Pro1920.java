package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1920 - 수 찾기
 */
public class Pro1920 {
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
            int res = bSearch(tmp);
            System.out.println(res);
        }
    }

    private static int bSearch(int target) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                if (arr[mid] == target)
                    return 1;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return 0;
    }
}
