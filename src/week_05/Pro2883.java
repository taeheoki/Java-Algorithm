package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2884번 알람 시계
 */
public class Pro2883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (M < 45) {
            H = H -1;
            H = (H < 0) ? 23 : H;
            M = (M + 15) % 60;
        } else {
            M = (M + 15) % 60;
        }
        System.out.println(H + " " + M);
    }
}
