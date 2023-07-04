package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 16937 - 두 스티커
 */
public class Pro16937 {
    static int H, W, N;
    static int[] R, C;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        R = new int[N];
        C = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }
        pro();
        System.out.println(max);
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            int tmpR = R[i];
            int tmpC = C[i];
            method(i, tmpR, tmpC);
            tmpR = C[i];
            tmpC = R[i];
            method(i, tmpR, tmpC);
        }
    }

    private static void method(int i, int tmpR, int tmpC) {
        for (int j = i + 1; j < N; j++) {
            int tmpR2 = R[j];
            int tmpC2 = C[j];
            if (isPossible(tmpR, tmpC, tmpR2, tmpC2)) {
                max = Math.max(max, tmpR * tmpC + tmpR2 * tmpC2);
            }
            tmpR2 = C[j];
            tmpC2 = R[j];
            if (isPossible(tmpR, tmpC, tmpR2, tmpC2)) {
                max = Math.max(max, tmpR * tmpC + tmpR2 * tmpC2);
            }
        }
    }

    private static boolean isPossible(int tmpR, int tmpC, int tmpR2, int tmpC2) {
        if (tmpR + tmpR2 <= H && Math.max(tmpC, tmpC2) <= W)
            return true;
        else if (Math.max(tmpR, tmpR2) <= H && tmpC + tmpC2 <= W)
            return true;
        return false;
    }
}
