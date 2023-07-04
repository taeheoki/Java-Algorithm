package src.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2475 검증수
 */
public class Pro2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        while (st.hasMoreTokens()) {
            res += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        System.out.println(res % 10);
    }
}
