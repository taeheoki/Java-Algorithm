package src.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BOJ 9081 - 단어 맞추기
 */
public class Pro9081 {
    static int T;
    static char[] tmp;
    static String str, res;
    static boolean flag;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            str = br.readLine();
            tmp = new char[str.length()];
            used = new boolean[str.length()];
            for (int i = 0; i < str.length(); i++) {
                tmp[i] = str.charAt(i);
            }
            Arrays.sort(tmp);
            flag = false;
            res = str;
            for (int i = 0; i < str.length(); i++) {
                used[i] = true;
                rec_func(1, String.valueOf(tmp[i]));
                if (flag)
                    break;
                used[i] = false;
            }
            System.out.println(res);
        }
    }

    private static void rec_func(int depth, String cmp) {
        if (depth == str.length()) {
            if (!str.equals(cmp)) {
                res = cmp;
                flag = true;
            }
            return;
        }
        String tmp2 = str.substring(0, depth);
        for (int i = 0; i < str.length(); i++) {
            if (flag)
                return;
            if (used[i])
                continue;
            int i1 = tmp2.compareTo(cmp);
            if (i1 >= 1)
                break;
            used[i] = true;
            rec_func(depth + 1, cmp + tmp[i]);
            used[i] = false;
        }
    }
}
