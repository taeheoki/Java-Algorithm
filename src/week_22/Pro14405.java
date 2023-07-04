package src.week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 14405 - 피카츄
 */
public class Pro14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.replace("pi", "0");
        str = str.replace("ka", "0");
        str = str.replace("chu", "0");
        str = str.replace("0", "");
        System.out.println(str.equals("") ? "YES" : "NO");
    }
}
