package src.week_34;

import java.util.Arrays;

/**
 * 프로그래머스 - 이진 변환 반복하기
 */
public class Pro70129 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int removeZero = 0;
        int afterLength = s.length();
        while (afterLength != 1) {
            int zeroCnt = getZeroCnt(s);
            removeZero += zeroCnt;
            afterLength = s.length() - zeroCnt;
            s = Long.toBinaryString(afterLength);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = removeZero;
        return answer;
    }

    private static int getZeroCnt(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '0')
                cnt++;
        }
        return cnt;
    }
}
