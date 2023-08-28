package src.week_35;

import java.util.*;

/**
 * 프로그래머스 - 쿼드압축 후 개수 세기
 */
public class Pro68936 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}})));
    }

    public static int[] solution(int[][] arr) {
        int[] answer = {};

        int n = arr.length;

        rec_func(0, 0, n, n, arr);

        // 개수 세기
        int zero = 0;
        int one = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0){
                    zero++;
                }else if(arr[i][j] == 1){
                    one++;
                }
            }
        }

        return new int[]{zero, one};
    }

    private static void rec_func(int r1, int c1, int r2, int c2, int[][] arr) {
        if (r2 - r1 == 1)
            return;
        if (checkNumber(r1, c1, r2, c2, arr)) {
            for (int i = r1; i < r2; i++) {
                for (int j = c1; j < c2; j++) {
                    if (i == r1 && j == c1)
                        continue;
                    arr[i][j] = -1;
                }
            }
        } else {
            int offset = (r2 - r1) / 2;
            rec_func(r1, c1, r1 + offset, c1 + offset, arr);
            rec_func(r1, c1 + offset, r1 + offset, c2, arr);
            rec_func(r1 + offset, c1, r2, c1 + offset, arr);
            rec_func(r1 + offset, c1 + offset, r2, c2, arr);
        }
    }

    private static boolean checkNumber(int r1, int c1, int r2, int c2, int[][] arr) {
        int pivot = arr[r1][c1];
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (arr[i][j] != pivot)
                    return false;
            }
        }
        return true;
    }
}
