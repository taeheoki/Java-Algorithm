package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * BOJ 2671 - 잠수함식별
 */
public class Pro2671 {
    static String bitStr;
    static String regex = "(100+1+|01)+";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bitStr = br.readLine();
        pro();
    }

    private static void pro() {
        if (Pattern.matches(regex, bitStr)) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }
    }
}
