package src.week_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 19948 - 음유시인 영재
 */
public class Pro19948 {
    static StringBuilder sb = new StringBuilder();
    static String[] contents;
    static int spaceBar;
    static int[] life = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        spaceBar = Integer.parseInt(br.readLine()) + 1;
        contents = new String[st.countTokens()];
        for (int i = 0; i < contents.length; i++) {
            contents[i] = st.nextToken();
            if (spaceBar-- == 0) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 26; i++) {
            life[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        for (String contentq : contents) {
            String content = contentq.toUpperCase();
            for (int i = 0; i < content.length(); i++) {
                char c = content.charAt(i);
                if (i == 0) {
                    life[c - 'A']--;
                    sb.append(c);
                }
                if (i == 0 || contentq.charAt(i - 1) != contentq.charAt(i))
                    life[c - 'A']--;
                if (life[c - 'A'] < 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(sb);
    }
}
