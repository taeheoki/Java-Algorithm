package src.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2525 - 오븐 시계
 */
public class Pro2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hh = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());
        int plusTime = Integer.parseInt(br.readLine());

        mm += plusTime;
        if (mm / 60 >= 1 ) {
            hh = (hh + mm / 60) % 24;
            mm %= 60;
        }
        System.out.println(hh + " " + mm);
    }
}
