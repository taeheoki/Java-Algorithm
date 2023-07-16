package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2138 - 전구와 스위치
 */
public class Pro2138 {
    static int N, res = Integer.MAX_VALUE;
    static String sourceStr;
    static char[] source, dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sourceStr = br.readLine();
        dest = br.readLine().toCharArray();
        pro();
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void pro() {
        // 0번 스위치를 누르고 시작
        int cnt = 0;
        source = sourceStr.toCharArray();
        for (int i = 1; i < sourceStr.length(); i++) {
            if (source[i - 1] != dest[i - 1]) {
                cnt++;
                source[i - 1] = source[i - 1] == '0' ? '1' : '0';
                source[i] = source[i] == '0' ? '1' : '0';
                if (i + 1 < sourceStr.length())
                    source[i + 1] = source[i + 1] == '0' ? '1' : '0';
            }
        }
        if (source[sourceStr.length() - 1] == dest[sourceStr.length() - 1])
            res = Math.min(res, cnt);
        // 0번 스위치를 누르지 않고 시작
        cnt = 1;
        source = sourceStr.toCharArray();
        source[0] = source[0] == '0' ? '1' : '0';
        source[1] = source[1] == '0' ? '1' : '0';
        for (int i = 1; i < sourceStr.length(); i++) {
            if (source[i - 1] != dest[i - 1]) {
                cnt++;
                source[i - 1] = source[i - 1] == '0' ? '1' : '0';
                source[i] = source[i] == '0' ? '1' : '0';
                if (i + 1 < sourceStr.length())
                    source[i + 1] = source[i + 1] == '0' ? '1' : '0';
            }
        }
        if (source[sourceStr.length() - 1] == dest[sourceStr.length() - 1])
            res = Math.min(res, cnt);
    }
}
