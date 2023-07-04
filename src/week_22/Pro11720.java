package src.week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 11720 - 숫자의 합
 */
public class Pro11720 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(str.substring(i, i + 1));
        }
        System.out.println(sum);
    }
}
