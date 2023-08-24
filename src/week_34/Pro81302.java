package src.week_34;

import java.util.Arrays;

/**
 * 프로그래머스 - 거리두기 확인하기
 */
public class Pro81302 {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean flag;
    static boolean[][] visit;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"POOPO", "OOOOO", "OOOXP", "OPOPX", "OOOOO"}})));
    }

    public static int[] solution(String[][] places) {
        int[] res = new int[places.length];
        int index = 0;
        for (String[] place : places) {
            visit = new boolean[place.length][place[0].length()];
            flag = false;
            for (int i = 0; i < place.length; i++) {
                for (int j = 0; j < place[i].length(); j++) {
                    if (flag)
                        break;
                    if (place[i].charAt(j) == 'P') {
                        visit[i][j] = true;
                        dfs(i, j, 0, place);
                    }
                }
            }
            res[index] = flag ? 0 : 1;
            index++;
        }
        return res;
    }

    private static void dfs(int y, int x, int dist, String[] place) {
        if (dist != 0 && dist <= 2 && place[y].charAt(x) == 'P')
            flag = true;
        if (flag)
            return;
        if (dist == 2)
            return;

        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];
            if (ny < 0 || nx < 0 || ny >= place.length || nx >= place[0].length())
                continue;
            if (place[ny].charAt(nx) == 'X')
                continue;
            if (visit[ny][nx])
                continue;
            visit[ny][nx] = true;
            dfs(ny, nx, dist + 1, place);
            visit[ny][nx] = false;
        }
    }
}
