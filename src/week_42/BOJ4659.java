package src.week_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 4659 - 비밀번호 발음하기
 */
public class BOJ4659 {
    static boolean flag;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while (!(str = br.readLine()).equals("end")) {
            flag = false;
            // 비교 검증 로직
            if (fisrtCond(str) && secondCond(str) && thirdCond(str))
                flag = true;
            sb.append("<" + str + "> is");
            if (!flag)
                sb.append(" not");
            sb.append(" acceptable.\n");
        }
        System.out.println(sb);
    }

    private static boolean thirdCond(String str) {
        char prev = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (prev == ch && !(ch == 'e' || ch == 'o'))
                return false;
            prev = ch;
        }
        return true;
    }

    private static boolean secondCond(String str) {
        int cCnt = 0;
        int pCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                pCnt++;
                cCnt = 0;
            } else {
                cCnt++;
                pCnt = 0;
            }
            if (pCnt == 3 || cCnt == 3)
                return false;
        }
        return true;
    }

    private static boolean fisrtCond(String str) {
        if (str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u"))
            return true;
        return false;
    }
}
