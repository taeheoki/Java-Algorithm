package src.week_16;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 프로그래머스 - 카펫
 */
public class Pro카펫 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        double total = (double) brown + yellow;
        int h = 2;
        int[] ans = {};
        while (true) {
            h++;
            if (total % h != 0)
                continue;
            int w = (int) total / h;
            if ((w - 2) * (h - 2) == yellow) {
                ans = new int[]{w, h};
                break;
            }
        }
        return ans;
    }
}
