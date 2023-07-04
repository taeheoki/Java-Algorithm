package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2609 - 최대공약수와 최소공배수
 */
public class Pro2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int v1 = 0, v2 = 0;
        for (int i = 1; i <= Math.min(A, B); i++) {
            if (A % i == 0 && B % i == 0)
                v1 = i;
        }
        int i = 1;
        while (true) {
            if (A * i % B == 0) {
                v2 = A * i;
                break;
            }
            i++;
        }
        System.out.println(v1);
        System.out.println(v2);
    }
}
