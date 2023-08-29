package src.week_35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 프로그래머스 - 테이블 해시 함수
 */
public class Pro147354 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3));
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] datum : data) {
            list.add(datum);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[col - 1] == o2[col - 1]) {
                    return Integer.compare(o2[0], o1[0]); // 첫 번째 컬럼 값에 대한 내림차순 정렐
                }
                return Integer.compare(o1[col - 1], o2[col - 1]); // col-1번째 컬럼 값에 대한 오름차순 정렐
            }
        });

        int[] arr = new int[row_end - row_begin + 1];
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int[] ints = list.get(i);
            int sum = 0;
            for (int j = 0; j < ints.length; j++) {
                sum += ints[j] % (i + 1);
            }
            arr[i - row_begin + 1] = sum;
        }
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }
}
