package src.week_33;

import java.util.Stack;

/**
 * 프로그래머스 - 괄호 변환
 */
public class Pro60058 {

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        // 1단계
        if (p.isEmpty())
            return p;
        // 2단계
        return rec_func(p);
    }

    private static String rec_func(String w) {
        if (w.isEmpty())
            return "";
        int cnt = 0;
        int i = 0;
        for (; i < w.length(); i++) {
            char tmp = w.charAt(i);
            if (tmp == '(')
                cnt++;
            else
                cnt--;
            if (cnt == 0)
                break;
        }
        String u = w.substring(0, i + 1);
        String v = w.substring(i + 1);
        if (isCorrect(u))
            return u + rec_func(v);
        else {
            String uTmp = "(" + rec_func(v) + ")";
            for (int j = 1; j < u.length() - 1; j++) {
                char tmp = u.charAt(j);
                if (tmp == '(')
                    uTmp += ")";
                else
                    uTmp += "(";
            }
            return uTmp;
        }
    }

    private static boolean isCorrect(String u) {
        int cnt = 0;
        for (int i = 0; i < u.length(); i++) {
            char tmp = u.charAt(i);
            if (tmp == '(')
                cnt++;
            else {
                cnt--;
                if (cnt < 0)
                    return false;
            }
        }
        return true;
    }
}
