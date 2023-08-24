package src.week_34;

import java.util.Arrays;

/**
 * 프로그래머스 - 2개 이하로 다른 비트
 */
public class Pro77885 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{2, 7})));
        System.out.println(Arrays.toString(solution(new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})));
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            long bit = 0;

            // 최하위 비트가 0인 위치를 찾습니다.
            while (((number >> bit) & 1) == 1) {
                bit++;
            }

            // 자리 수를 변경합니다.
            answer[i] = number + (1L << bit);
            if (bit > 0) {
                answer[i] -= (1L << (bit - 1));
            }
        }

        return answer;
    }
}
