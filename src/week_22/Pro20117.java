package src.week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 20117 - 호반우 상인의 이상한 품질 계산법
 */
public class Pro20117 {
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
        Arrays.sort(arr);

        int sum =0;
        for (int i = 0; i <= N / 2; i++) {
            if (i > N - i - 1) {
                break;
            }
            if (i != N - i - 1) {
                sum += arr[N - i - 1] * 2;
            } else {
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }
}
