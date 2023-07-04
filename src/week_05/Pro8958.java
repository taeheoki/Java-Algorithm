package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 8958번 OX퀴즈
 */
public class Pro8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String data = br.readLine();
            int sum = 0;
            int cnt = 1;
            for (int j = 0; j < data.length(); j++) {
                if (data.charAt(j) == 'O') {
                    sum += cnt++;
                } else {
                    cnt = 1;
                }
            }
            System.out.println(sum);
        }
    }
}
