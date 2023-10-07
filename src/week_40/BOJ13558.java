package src.week_40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 13558 - 등차수열의 개수
 */
public class BOJ13558 {
    static int N;
    static int[] left = new int[30000 + 1];
    static int[] right = new int[30000 + 1];
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            right[num]++;
        }

        right[arr[0]]--;
        for (int i = 1; i < N - 1; i++) {
            left[arr[i - 1]]++;
            right[arr[i]]--;
            int max = Math.min(arr[i], 30000 - arr[i]);
            for (int j = -max; j <= max; j++) {
                res += left[arr[i] - j] * (long) right[arr[i] + j];
            }
        }
        System.out.println(res);
    }
}
