package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 27866 - 문자와 문자열
 */
public class Pro27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        int index = Integer.parseInt(br.readLine()) - 1;
        System.out.println(data.charAt(index));
    }
}
