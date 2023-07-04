package src.week_14;

import java.util.Arrays;
import java.util.Collections;

/**
 * 프로그래머스 - 최솟값 만들기
 * 문제 이해: 길이가 같은 배열 AB가 주어졌을 배열에서 숫자를 각출하여 서로 곱한 값을 누적한다.
 *          이때 가장 최솟값을 만들때 값은 얼마인가?
 */
public class Pro최솟값만들기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Integer[] tmpB = new Integer[B.length];
        for (int i = 0; i < B.length; i++) {
            tmpB[i] = B[i];
        }
        Arrays.sort(tmpB, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * tmpB[i];
        }
        return sum;
    }
}
