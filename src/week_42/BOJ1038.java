package src.week_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1038 - 감소하는 수
 */
public class BOJ1038 {
    static int N, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec_func(0, 0);
    }

    private static void rec_func(int rank, int num) {
        if (rank == num) {
            System.out.println(num);
            System.exit(0);
        }

    }
}
