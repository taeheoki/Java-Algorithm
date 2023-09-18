package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1522 - 문자열 교환
 */
public class BOJ1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int min = Integer.MAX_VALUE;

        int aCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a')
                aCnt++;
        }

        for (int i = 0; i < str.length(); i++) {
            int bCnt = 0;
            for (int j = i; j < i + aCnt; j++) {
                int idx = j % str.length();
                if (str.charAt(idx) == 'b')
                    bCnt++;
            }
            min = Math.min(min, bCnt);
        }
        System.out.println(min);
    }
}
