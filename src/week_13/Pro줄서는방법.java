package src.week_13;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 프로그래머스 - 줄 서는 방법
 */
public class Pro줄서는방법 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(20, 2432902008176640000L)));
//        System.out.println(2432902008176640000L);
    }

    public static int[] solution(int n, long k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        int i = n;
        k--;
        int j = 0;
        while (!arr.isEmpty()) {
            int pos = (int) (k / (factorial(i) / i));
            k %= factorial(i) / i;
            res[j++] = arr.remove(pos);
            i--;
        }
        return res;
    }

    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
