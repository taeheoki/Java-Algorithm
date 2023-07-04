package src.week_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 11365 - !밀비 급일
 */
public class Pro11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = null;
        while (!(str = br.readLine()).equals("END")) {
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
