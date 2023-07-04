package src.week_14;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 프로그래머스 - 하노이의 탑
 * 문제 이해: 한 기둥에 원판들이 작은 것이 위에 있도록 순서대로 쌓여 있다.
 *          게임의 목적은 두 가지 조건을 만족시키면서, 한 기둥에 꽂힌 원판들을 그 순서 그대로 다른 기둥으로 옮겨서 다시 쌓는 것입니다.
 *          1. 한 번에 하나의 원판만 옮길 수 있다.
 *          2. 큰 원판이 작은 원판 위에 있어서는 안된다.
 */
public class Pro하노이의탑 {
    static ArrayList<int[]> arr;

    public static void main(String[] args) {
//        System.out.println(solution(2));
        System.out.println(solution(3));
    }

    public static int[][] solution(int n) {
        arr = new ArrayList<>();
        rec_func(n, 1, 3, 2);

        int[][] res = new int[arr.size()][];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    private static void rec_func(int n, int from, int to, int rest) {
        if (n == 0)
            return;
        rec_func(n - 1, from, rest, to);
        arr.add(new int[]{from, to});
        rec_func(n - 1, rest, to, from);
    }
}