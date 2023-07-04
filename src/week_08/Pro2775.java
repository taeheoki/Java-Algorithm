package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2775 - 부녀회장이 될테야
 * 문제 이해: 0층 i호는 i명이 산다.
 *          k = 2, n = 3;
 *          0: 1 + 2 + 3
 *          1: 1 + 3 + 6
 */
public class Pro2775 {
    static StringBuilder sb = new StringBuilder();
    static int T, k, n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine()) + 1;
            n = Integer.parseInt(br.readLine()) + 1;
            pro();
        }
    }

    private static void pro() {
        arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    arr[i][j] = j + 1;
                } else {
                    for (int k = 0; k <= j; k++) {
                        arr[i][j] += arr[i - 1][k];
                    }
                }
            }
        }
        System.out.println(arr[k - 1][n - 2]);
    }
}
