package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1213 - 팰린드롬 만들기
 */
public class BOJ1213 {
    static int length;
    static int[] alphabets;

    public static void main(String[] args) throws IOException {
        init();
        pro();
    }

    private static void pro() {
        int oddCnt = 0;
        int evenCnt = 0;
        for (int alphabet : alphabets) {
            if (alphabet % 2 == 1)
                oddCnt++;
            else
                evenCnt++;
        }
        boolean flag = false;
        if ((length % 2 == 1 && oddCnt == 1) || (length % 2 == 0 && oddCnt == 0)) {
            flag = true;
        }
        System.out.println(flag ? getPanlin() : "I'm Sorry Hansoo");
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        length = str.length();
        alphabets = new int[26];
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            alphabets[ch - 'A']++;
        }
    }

    public static String getPanlin() {
        String res = null;
        StringBuilder sb = new StringBuilder();
        if (length % 2 == 0) {
            for (int i = 0; i < 26; i++) {
                int size = alphabets[i];
                for (int j = 0; j < size / 2; j++) {
                    sb.append((char) (i + 'A'));
                }
            }
            res = sb.toString() + sb.reverse();
        } else {
            int center = 0;
            for (int i = 0; i < 26; i++) {
                int size = alphabets[i];
                if (size % 2 == 1)
                    center = i;
                for (int j = 0; j < size / 2; j++) {
                    sb.append((char) (i + 'A'));
                }
            }
            res = sb.toString() + (char) (center + 'A') + sb.reverse();
        }
        return res;
    }
}
