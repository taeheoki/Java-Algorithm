package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1436 - 영화감독 숌
 * 문제 이해:
 */
public class Pro1436 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec_func(0, 665);
    }

    private static void rec_func(int depth, int pre) {
        if (depth == N) {
            System.out.println(pre);
        } else {
            while (true) {
                pre++;
                String tmp = String.valueOf(pre);
                if (tmp.contains("666")) {
                    rec_func(depth + 1, pre);
                    break;
                }
            }
        }
    }
}