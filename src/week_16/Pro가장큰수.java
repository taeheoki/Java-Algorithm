package src.week_16;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 프로그래머스 - 가장 큰 수
 * 문제 이해: 사전 수 배열로 정렬하고 다 이어 붙으면 될 듯
 */
public class Pro가장큰수 {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{6, 10, 2}));
//        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
//        System.out.println(solution(new int[]{123, 1232}));
//        System.out.println(solution(new int[]{1, 10, 100, 1000, 818, 81, 898, 89, 0, 0}));
//        System.out.println(solution(new int[]{0, 0, 0, 0, 1}));
//        System.out.println(solution(new int[]{12, 1213}));
//        System.out.println(solution(new int[]{1000, 999}));
        System.out.println(solution(new int[]{898, 89}));
        System.out.println(solution(new int[]{818, 81}));
    }

    public static String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String ans = "";
        for (int i = 0; i < numbers.length; i++) {
            ans += numStrs[i];
        }
        if (ans.charAt(0) == '0') {
            return "0";
        }
        return ans;
    }
}
