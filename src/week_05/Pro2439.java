package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2439번 별 찍기 - 2
 */
public class Pro2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (i > j)
                    sb.append(" ");
                else
                    sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
