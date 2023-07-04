package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * # BOJ 1972 - 놀라운 문자열
 */
public class Pro1972 {
    static StringBuilder sb = new StringBuilder();
    static char[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            tmp = br.readLine().toCharArray();
            if (String.valueOf(tmp).equals("*"))
                break;
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        Set<String> set = new HashSet<>();
        int i = 1;
        while (i <= tmp.length - 1) {
            for (int j = 0; j + i < tmp.length; j++) {
                String tmpStr = tmp[j] + "" + tmp[j + i];
                if (set.contains(tmpStr)) {
                    sb.append(tmp).append(" is NOT surprising.").append("\n");
                    return;
                }
                set.add(tmpStr);
            }
            i++;
            set.clear();
        }
        sb.append(tmp).append(" is surprising.").append("\n");
    }
}
