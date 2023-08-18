package src.week_32;

import java.util.StringTokenizer;

/**
 * 프로그래머스 - k진수에서 소수 개수 구하기
 */
public class Pro92335 {
    static int res;

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
//        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {
        String tmp = transform(n, k);
        StringTokenizer st = new StringTokenizer(tmp, "0");
        while (st.hasMoreTokens()) {
            double num = Double.parseDouble(st.nextToken());
            if (isPrime(num))
                res++;
        }
        return res;
    }

    private static boolean isPrime(double num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static String transform(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
}
