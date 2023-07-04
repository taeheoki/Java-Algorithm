package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1978 - 소수 찾기
 */
public class Pro1978 {
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (isPrimeNum(tmp))
                cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isPrimeNum(int num) {
        if (num == 1)
            return false;
        int start = 2;
        int end = (int) Math.sqrt(num);
        for (int i = start; i <= end; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
