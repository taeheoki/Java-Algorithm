package src.week_35;

import java.util.Arrays;

/**
 * 프로그래머스 - 숫자 카드 나누기
 */
public class Pro135807 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int a = getGCD(arrayA);
        boolean conditionFirst = isPossible(a, arrayB);
        int b = getGCD(arrayB);
        boolean conditionSecond = isPossible(b, arrayA);

        int answer = 0;
        if (conditionFirst && conditionSecond)
            answer = Math.max(a, b);
        else if (conditionFirst)
            answer = a;
        else if (conditionSecond)
            answer = b;
        return answer;
    }

    private static boolean isPossible(int a, int[] arrayB) {
        if (a == 1)
            return false;
        for (int num : arrayB) {
            if (num % a == 0)
                return false;
        }
        return true;
    }

    private static int getGCD(int[] arrayA) {
        int a = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            a = getEuclid(a, arrayA[i]);
        }
        return a;
    }

    private static int getEuclid(int min, int max) {
        if (max % min == 0)
            return min;
        return getEuclid(max % min, min);
    }
}
