package src.week_16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 소수 찾기
 */
public class Pro소수찾기 {
    static int cnt;
    static int[] arr;
    static boolean[] used;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
//        System.out.println(solution("17"));
        System.out.println(solution("143"));
        System.out.println(set);
//        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        arr = new int[numbers.length()];
        used = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        rec_func(0, 0);
        return set.size();
    }

    private static void rec_func(int depth, int num) {
        if (depth == arr.length) {
            if (isPrime(num))
                set.add(num);
            return;
        }
        rec_func(depth + 1, num);
        for (int i = 0; i < used.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            rec_func(depth + 1, num * 10 + arr[i]);
            used[i] = false;
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        if (num == 0 || num == 1)
            return false;
        return true;
    }
}
