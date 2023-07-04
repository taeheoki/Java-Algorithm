package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10872번 팩토리얼
 */
public class Pro10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res = factorial(N);
        System.out.println(res);
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else {
            return n * factorial(n - 1);
        }
    }

}
