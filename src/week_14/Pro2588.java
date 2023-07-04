package src.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2588 - 곱셈
 */
public class Pro2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int tmp1 = A * (B % 10);
        System.out.println(tmp1);
        B /= 10;
        int tmp2 = A * (B % 10);
        System.out.println(tmp2);
        B /= 10;
        int tmp3 = A * (B % 10);
        System.out.println(tmp3);
        System.out.println(tmp1 + tmp2 * 10 + tmp3 * 100);
    }
}
