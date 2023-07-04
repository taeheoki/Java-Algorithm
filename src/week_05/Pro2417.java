package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2417번 정수 제곱근
 */
public class Pro2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        long l = 0;
        long r = (long) Math.sqrt(Math.pow(2, 63)) + 1;;
        long res = n;
        while (l <= r) {
            long mid = (l + r) / 2;
            long X =  (long) Math.pow(mid, 2);
            if (X >= n) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(res);
    }
}
