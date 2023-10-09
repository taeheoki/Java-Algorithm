package src.week_40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 22858 - 원상 복구 (small)
 */
public class BOJ22858 {
    static int N, K;
    static int[] sArr, dArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sArr = new int[N];
        dArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sArr[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dArr[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        pro();
    }

    private static void pro() {
        while (K-- > 0) {
            int[] dest = new int[N];
            for (int i = 0; i < N; i++) {
                dest[dArr[i]] = sArr[i];
            }
            sArr = dest.clone();
        }
        for (int i : sArr) {
            System.out.print(i + 1 + " ");
        }
    }
}
