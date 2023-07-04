package src.codingtest_2;

import java.util.Arrays;

public class Pro3 {
    static final int TAXI_SIZE = 4;
    static int res;
    static int[] arr = new int[4 + 1];

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 2, 4, 3, 3}));
//        System.out.println(solution(new int[]{1, 2, 4, 3, 3}));
//        System.out.println(solution(new int[]{2, 3, 4, 4, 2, 1, 3, 1}));
//        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 4, 4}));
//        System.out.println(solution(new int[]{1, 1, 1, 1, 1}));
//        System.out.println(solution(new int[]{1, 1, 1, 2, 2, 3, 4}));
//        System.out.println(solution(new int[]{1, 1, 2, 2, 2, 3, 4}));
//        System.out.println(solution(new int[]{2, 2, 2, 2, 1}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3}));
    }

    public static int solution(int[] s) {
        arr = new int[4 + 1];
        for (int i = 0; i < s.length; i++)
            arr[s[i]]++;
        pro();
        return res;
    }

    private static void pro() {
        res = 0;
        res += arr[4];
        int tmp = Math.min(arr[1], arr[3]);
        arr[1] -= tmp;
        arr[3] -= tmp;
        if (arr[3] > 0) {
            res += tmp + arr[3];
            res += (arr[2] % 2 == 1) ? arr[2] / 2 + 1: arr[2] / 2;
        } else {
            res += tmp;
            res += arr[2] / 2;
            arr[2] = (arr[2] % 2 == 1) ? 1 : 0;
            if (arr[2] == 1 && arr[1] <= 2) {
                res++;
                return;
            } else if (arr[2] == 1) {
                res++;
                arr[1] -= 2;
            }
            res += arr[1] / TAXI_SIZE;
            if (arr[1] % TAXI_SIZE > 0)
                res++;
        }
    }
}
