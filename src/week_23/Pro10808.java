package src.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 10808 - 알파벳 개수
 */
public class Pro10808 {
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            alphabet[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alphabet[i]).append(' ');
        }
        System.out.println(sb);
    }
}
