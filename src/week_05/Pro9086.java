package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9086번 문자열
 */
public class Pro9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            char first = tmp.charAt(0);
            char last = tmp.charAt(tmp.length() - 1);
            sb.append(first + "" +  last + "\n");
        }
        System.out.println(sb);
    }
}
