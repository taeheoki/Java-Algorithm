package src.week_16;

import java.util.Arrays;
import java.util.Collections;

/**
 * 프로그래머스 - H-Index
 */
public class ProH_Index {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{1, 4, 5}));
        System.out.println(solution(new int[]{5, 6, 7}));
    }

    public static int solution(int[] citations) {
        Integer[] tmp = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            tmp[i] = citations[i];
        }
        Arrays.sort(tmp, Collections.reverseOrder());

        int res = 0;
        int left = 0;
        int right = 10000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, tmp)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private static boolean isPossible(int mid, Integer[] tmp) {
        int cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] >= mid)
                cnt++;
            else
                break;
        }
        return cnt >= mid;
    }
}
