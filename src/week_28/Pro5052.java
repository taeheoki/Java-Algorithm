package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * BOJ 5052 - 전화번호 목록
 */
public class Pro5052 {
    static StringBuilder sb = new StringBuilder();
    static int t, n;
    static String[] strs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            strs = new String[n];
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                strs[i] = br.readLine();
            }
            Arrays.sort(strs);
            for (int i = 0; i < n - 1; i++) {
                if (strs[i + 1].indexOf(strs[i]) == 0) {
                    sb.append("NO").append('\n');
                    flag = true;
                    break;
                }
            }
            if (!flag)
                sb.append("YES").append('\n');
        }
        System.out.println(sb);
    }
}
