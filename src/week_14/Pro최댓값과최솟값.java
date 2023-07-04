package src.week_14;

import java.util.StringTokenizer;

/**
 * 프로그래머스 - 최댓값과 최솟값
 */
public class Pro최댓값과최솟값 {

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }

    public static String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
        }
        String answer = min + " " + max;
        return answer;
    }
}
