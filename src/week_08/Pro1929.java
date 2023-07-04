package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1929 - 소수 구하기
 */
public class Pro1929 {
    static int M, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        arr = new int[N + 1];
        for (int i = 2; i <= N; i++)
            arr[i] = i;

        for (int i = 2; i <= N; i++) {
            for (int j = i * 2; j <= N; j += i) {
                arr[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i] != 0)
                System.out.println(arr[i]);
        }
    }
}
