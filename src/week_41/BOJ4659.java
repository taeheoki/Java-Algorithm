package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 4659 - 비밀번호 발음하기
 */
public class BOJ4659 {
    static String vowel = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while (!(str = br.readLine()).equals("end")) {
            boolean flag = true;
            if (!checkFirst(str) || !checkSecond(str) || !checkThird(str))
                flag = false;
            System.out.print("<" + str + "> is ");
            System.out.println(flag ? "acceptable." : "not acceptable.");
        }
    }

    private static boolean checkThird(String str) {
        char prev = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (prev == ch && !(ch == 'e' || ch == 'o'))
                return false;
            prev = ch;
        }
        return true;
    }

    private static boolean checkSecond(String str) {
        int pCnt = 0;
        int cCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowel.contains(String.valueOf(ch))) {
                pCnt++;
                cCnt = 0;
            } else {
                pCnt = 0;
                cCnt++;
            }
            if (pCnt == 3 || cCnt == 3)
                return false;
        }
        return true;
    }

    private static boolean checkFirst(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowel.contains(String.valueOf(ch)))
                return true;
        }
        return false;
    }
}
