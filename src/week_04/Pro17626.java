package src.week_04;

import java.io.*;

/**
 * 백준 17626번 Four Squares
 */
public class Pro17626 {
    static int N, remainder, min = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec_func(0, N);
        System.out.println(min);
    }

    private static void rec_func(int depth, int n) {
        if ((depth == min && n != 0) || depth > min) {
            return;
        } else if (n == 0) {
            min = Math.min(min, depth);
        } else {
            remainder = (int) Math.sqrt(n);
            for (int i = remainder; i > remainder - 3; i--) {
                rec_func(depth + 1, (int) (n - Math.pow(i, 2)));
            }
        }
    }
}
