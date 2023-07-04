package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2577번 숫자의 개수
 */
public class Pro2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int[] used = new int[10];
        String sNum = String.valueOf(A * B * C);
        for (int i = 0; i < sNum.length(); i++) {
            used[sNum.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(used[i]);
        }
    }
}
