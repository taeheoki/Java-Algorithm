package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2420번 사파리월드
 */
public class Pro2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long N = Long.parseLong(st.nextToken());
        Long M = Long.parseLong(st.nextToken());
        System.out.println(Math.abs(N - M));
    }
}
