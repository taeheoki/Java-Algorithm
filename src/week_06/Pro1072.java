package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1072번 게임
 */
public class Pro1072 {
    static long X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        // 10 8이 주어졌을 때 Z는 80
        // 10 + 1 : 8 + 1 -> Z =
        // 100 80
        // 100 + x : 80 + x -> Z의 변화가 생기는 수
        long left = 0;
        long right = X;
        long res = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            boolean tmp = possible(mid);
            if (tmp) {
                res = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(res == 0 ? -1 : res);
    }

    private static boolean possible(long mid) {
        boolean flag = false;
        long Z = (Y * 100) / X;
        long newZ = ((Y + mid) * 100) / (X + mid);
        if (Z != newZ)
            flag = true;
        return flag;
    }
}