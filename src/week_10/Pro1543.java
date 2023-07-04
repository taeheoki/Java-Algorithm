package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1543 - 문서 검색
 */
public class Pro1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder src = new StringBuilder(br.readLine());
        String cmp = br.readLine();
        int cnt = 0;
        int index = -1;
        while ((index = src.indexOf(cmp, index + 1)) != -1) {
            cnt++;
            index += cmp.length() - 1;
        }
        System.out.println(cnt);
    }
}
