package src.week_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * BOJ 5052 - 전화번호 목록
 */
public class BOJ5052 {
    static StringBuilder sb = new StringBuilder();
    static int t, n;
    static TreeSet<String> list = new TreeSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++)
                list.add(br.readLine());
            sb.append(checkCond() ? "YES" : "NO").append('\n');
            list.clear();
        }
        System.out.println(sb);
    }

    private static boolean checkCond() {
        String str = "qwe";
        for (String cmp : list) {
            if (cmp.startsWith(str))
                return false;
            str = cmp;
        }
        return true;
    }
}
