package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2675번 문자열 반복
 */
public class Pro2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(S.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}