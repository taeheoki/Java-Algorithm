package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 22862 - 가장 긴 짝수 연속한 부분 수열 (large)
 */
public class Pro22862 {
    static int N, K, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int right = 0;
        int rm = K;
        for (int left = 1; left <= N; left++) {
            if (arr[left - 1] % 2 != 0 && rm != K)
                rm++;
            while (right + 1 <= N) {
                right++;
                if (arr[right] % 2 != 0) {
                    if (rm > 0) {
                        rm--;
                        continue;
                    }
                    right--;
                    break;
                }
            }
            res = Math.max(res, right - left + 1 - (K - rm));
        }
        System.out.println(res);
    }
}

