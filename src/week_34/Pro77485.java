package src.week_34;

import java.util.Arrays;

/**
 * 프로그래머스 - 행렬 테두리 회전하기
 */
public class Pro77485 {
    static int[][] map;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
        System.out.println(Arrays.toString(solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
        System.out.println(Arrays.toString(solution(3, 4, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
        System.out.println(Arrays.toString(solution(100, 97, new int[][]{{1, 1, 100, 97}})));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = i * columns + j + 1;
            }
        }
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int r1 = query[0] - 1;
            int c1 = query[1] - 1;
            int r2 = query[2] - 1;
            int c2 = query[3] - 1;
            int tmp = map[r1][c2];
            int min = tmp;
            // 위
            for (int i = c2; i >= c1 + 1; i--) {
                map[r1][i] = map[r1][i - 1];
                min = Math.min(min, map[r1][i]);
            }
            // 왼쪽
            for (int i = r1; i <= r2 - 1; i++) {
                map[i][c1] = map[i + 1][c1];
                min = Math.min(min, map[i][c1]);
            }
            // 아래
            for (int i = c1; i <= c2 - 1; i++) {
                map[r2][i] = map[r2][i + 1];
                min = Math.min(min, map[r2][i]);
            }
            // 오른쪽
            for (int i = r2; i >= r1 + 1; i--) {
                map[i][c2] = map[i - 1][c2];
                min = Math.min(min, map[i][c2]);
            }
            map[r1 + 1][c2] = tmp;
            answer[index] = min;
            index++;
        }
        return answer;
    }
}
