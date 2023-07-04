package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 13397번 구간 나구기 2
 */
public class Pro13397 {
    static int N, M, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        binarySearch();
    }

    private static void binarySearch() {
        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt();
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = getCount(mid);
            if (tmp <= M) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        System.out.println(res);
    }

    private static int getCount(int mid) {
        int count = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            if (max - min > mid) {
                count++;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                i--;
            }
        }
        return count;
    }
}
