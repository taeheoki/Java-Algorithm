package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1546번 평균
 */
public class Pro1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i ++) {
            int tmp = Integer.parseInt(st.nextToken());
            sum += tmp;
            max = Math.max(max, tmp);
        }
        System.out.println((double) sum / (max * N) * 100);
    }
}
