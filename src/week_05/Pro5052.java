package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 5052번 전호번호 목록
 */
public class Pro5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            boolean flag = false;
            int n = Integer.parseInt(br.readLine());
            String[] phoneBook = new String[n];
            for (int j = 0; j < n; j++) {
                phoneBook[j] = br.readLine();
            }
            Arrays.sort(phoneBook);
            for (int j = 1; j < n; j++) {
                if (phoneBook[j].charAt(0) == phoneBook[j-1].charAt(0) && phoneBook[j].contains(phoneBook[j - 1])) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                sb.append("NO" + "\n");
            else
                sb.append("YES" + "\n");
        }
        System.out.println(sb);
    }
}
