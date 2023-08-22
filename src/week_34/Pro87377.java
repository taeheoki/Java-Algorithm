package src.week_34;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 프로그래머스 - 교점에 별 만들기
 */
public class Pro87377 {
    static Long xMin = Long.MAX_VALUE, xMax = Long.MIN_VALUE, yMin = Long.MAX_VALUE, yMax = Long.MIN_VALUE;
    static HashSet<long[]> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}}));
        init();
        System.out.println(solution(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}}));
        init();
        System.out.println(solution(new int[][]{{1, -1, 0}, {2, -1, 0}}));
        init();
        System.out.println(solution(new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}}));
    }

    private static void init() {
        set.clear();
        xMin = Long.MAX_VALUE;
        xMax = Long.MIN_VALUE;
        yMin = Long.MAX_VALUE;
        yMax = Long.MIN_VALUE;
    }

    public static String[] solution(int[][] line) {
        for (int i = 0; i < line.length; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                long xc = B * F - E * D;
                long yc = E * C - A * F;
                long m = A * D - B * C;
                if (m != 0 && xc % m == 0 && yc % m == 0) {
                    set.add(new long[]{yc / m, xc / m});
                    xMin = Math.min(xMin, xc / m);
                    xMax = Math.max(xMax, xc / m);
                    yMin = Math.min(yMin, yc / m);
                    yMax = Math.max(yMax, yc / m);
                }
            }
        }
        StringBuilder[] sbArr = new StringBuilder[(int) (yMax - yMin + 1)];
        char[][] res = new char[(int) (yMax - yMin + 1)][(int) (xMax - xMin + 1)];
        for (int i = 0; i < res.length; i++)
            Arrays.fill(res[i], '.');
        for (long[] longs : set) {
            res[(int) (longs[0] - yMin)][(int) (longs[1] - xMin)] = '*';
        }
        String[] answer = new String[res.length];
        for (int i = 0; i < res.length; i++) {
            answer[res.length - i - 1] = String.valueOf(res[i]);
        }
        return answer;
    }
}
