package src.week_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1072 - 게임
 */
public class Pro1072 {
    static long X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = (Y * 100) / X;
//        if (Z == 100) {
//            System.out.println(-1);
//            System.exit(0);
//        }
        long left = 0;
        long right = X;
        long res = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isCondition(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid  +1;
            }
        }
        System.out.println(res == 0 ? -1 : res);
    }

    private static boolean isCondition(long mid) {
        long Z2 = ((Y + mid) * 100) / (X + mid);
        if (Z != Z2)
            return true;
        return false;
    }
}
