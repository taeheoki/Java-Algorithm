package src.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 1456 - 거의 소수
 */
public class Pro1456 {
    static long A, B;
    static boolean[] primes;
//    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        int max = 10000000;

        // B 이하의 소수 리스트를 뽑는다.
//        getPrimes(B);
        primes = new boolean[max + 1];
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i < max; i++) {
            if (primes[i])
                continue;
            for (int j = i * 2; j <= max; j += i) {
                primes[j] = true;
            }
        }

        int cnt = 0;

        for (int i = 2; i <= max; i++) {
            if (i * i > B)
                break;
            if (primes[i])
                continue;
            for (int j = 2; ; j++) {
                if ((long) Math.pow(i, j) > B)
                    break;
                if ((long) Math.pow(i, j) < A)
                    continue;
                cnt++;
            }
        }

//        for (int prime : arr) {
//            int x = 2;
//            double pow = Math.pow(prime, x);
//            while (pow <= B) {
//                if (pow >= A)
//                    cnt++;
//                x++;
//                pow = Math.pow(prime, x);
//            }
//        }
        System.out.println(cnt);
    }

//    private static void getPrimes(long num) {
//        double sqrt = Math.sqrt(num);
//        for (int i = 2; i <= (int) sqrt; i++) {
//            if (isPrime(i))
//                arr.add(i);
//        }
//    }

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
