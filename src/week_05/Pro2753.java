package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2753번 윤년
 */
public class Pro2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num % 4 == 0) {
            if (num % 100 != 0 || num % 400 == 0) {
                System.out.println(1);
                System.exit(0);
            }
        }
        System.out.println(0);
    }
}
