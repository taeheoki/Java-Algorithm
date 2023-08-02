package src.week_31;

import java.util.Arrays;

/**
 *
 */
public class Pro표현_가능한_이진트리 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{7, 42, 5})));
        System.out.println(Arrays.toString(solution(new long[]{63, 111, 95})));
        System.out.println(Arrays.toString(solution(new long[]{423})));
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int n = 0;
        for (long number : numbers) {
            String binaryNum = getBinaryNum(number);
            boolean flag = false;
            for (int i = 0; i < binaryNum.length(); i++) {
                char tmp = binaryNum.charAt(i);
                if (tmp == '0' && i % 2 == 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                answer[n] = 0;
            } else {
                answer[n] = 1;
            }
            n++;
        }
        return answer;
    }

    private static String getBinaryNum(long number) {
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            if (number % 2 != 0) {
                sb.append(1);
                number--;
            } else
                sb.append(0);
            number /= 2;
        }
        if (sb.length() % 2 == 0)
            sb.append(0);
        return String.valueOf(sb.reverse());
    }
}
