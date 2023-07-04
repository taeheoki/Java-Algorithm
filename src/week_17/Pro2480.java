package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2480 - 주사위 세개
 */
public class Pro2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int[] arr = new int[7];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            int idx = Integer.parseInt(st.nextToken());
            arr[idx]++;
            max = Math.max(max, idx);
        }
        for (int i = 1; i <= 6; i++) {
            int tmp = arr[i];
            if (tmp == 3) {
                ans = 10000 + i * 1000;
            } else if (tmp == 2) {
                ans = 1000 + i * 100;
            }
        }
        if (ans == 0) {
            ans = max * 100;
        }
        System.out.println(ans);
    }
}
