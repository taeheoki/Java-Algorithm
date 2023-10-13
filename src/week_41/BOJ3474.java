package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3474 {
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            pro(num);
        }
        System.out.println(sb);
    }

    private static void pro(int num) {
        long fiveCnt = 0;
        for (long i = 5; i <= num; i *= 5)
            fiveCnt += num / i;
        sb.append(fiveCnt).append('\n');
    }
}
