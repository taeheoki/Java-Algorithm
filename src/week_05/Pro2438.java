package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2438번 별 찍기 - 1
 */
public class Pro2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder star = new StringBuilder();
        for (int i = 0; i < N; i++) {
            star.append("*");
            sb.append(star + "\n");
        }
        System.out.println(sb);
    }
}
