package src.week_35;

import java.util.HashSet;

/**
 * 프로그래머스  - 연속 부분 수열 합의 개수
 */
public class Pro131701 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 9, 1, 1, 4}));
    }

    public static int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += elements[k % elements.length];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
