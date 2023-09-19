package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 14719 - 빗물
 */
public class BOJ14719 {
    static int H, W;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Arrays.stream(arr).max().getAsInt();

        int prev = 0;
        int sum = 0;
        // 왼쪽 -> 오른쪽
        int i = 0;
        for (; i < W; i++) {
            if (arr[i] == max)
                break;
            else if (prev > arr[i]) {
                sum += prev - arr[i];
            } else if (prev < arr[i]) {
                prev = arr[i];
            }
        }
        prev = 0;
        int j = W - 1;
        // 오른쪽 -> 왼쪽
        for (; j >= 0; j--) {
            if (arr[j] == max)
                break;
            else if (prev > arr[j]) {
                sum += prev - arr[j];
            } else if (prev < arr[j]) {
                prev = arr[j];
            }
        }
        // 양 사이드
        for (int k = i; k <= j; k++) {
            sum += max - arr[k];
        }
        System.out.println(sum);
    }
}
