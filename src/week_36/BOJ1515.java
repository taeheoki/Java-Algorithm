package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1515 - 수 이어 쓰기
 */
public class BOJ1515 {
    static String numStr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numStr = br.readLine();
        pro();
    }

    private static void pro() {

        int check = 0;

        for (int i = 1; i <= 30000; i++) {
            String tmp = String.valueOf(i);

            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == numStr.charAt(check))
                    check++;
                if (check == numStr.length()) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
