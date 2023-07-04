package src.week_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 프로그래머스 - 구명보트
 */
public class Pro구명보트 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
        System.out.println(solution(new int[]{20, 30, 30, 50, 70}, 100));
    }


    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        int left = 0;
        int right  = people.length - 1;
        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            cnt++;
        }
        return cnt;
    }
}
