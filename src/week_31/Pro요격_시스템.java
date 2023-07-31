package src.week_31;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 프로그래머스 - 요격 시스템
 */
public class Pro요격_시스템 {
    public static void main(String[] args) {
        Pro요격_시스템 pro요격_시스템 = new Pro요격_시스템();
        System.out.println(pro요격_시스템.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
    }

    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (x, y) -> x[0] - y[0]);

        int prevStart = targets[0][0];
        int prevEnd = targets[0][1];

        for (int[] target : targets) {
            if (answer == 0) {
                answer++;
                continue;
            }

            int curStart = target[0];
            int curEnd = target[1];

            if (prevStart <= curStart && curStart < prevEnd) {
                prevStart = curStart;
                prevEnd = Math.min(prevEnd, curEnd);
            } else {
                prevStart = curStart;
                prevEnd = curEnd;
                answer++;
            }
        }
        return answer;
    }
}
