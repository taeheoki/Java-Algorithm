package src.week_34;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프로그래머스 - 빛의 경로 사이클
 */
public class Pro86052 {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][][] board;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"SL", "LR"})));
        System.out.println(Arrays.toString(solution(new String[]{"S"})));
        System.out.println(Arrays.toString(solution(new String[]{"R","R"})));
    }

    public static int[] solution(String[] grid) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        board = new int[grid.length][grid[0].length()][4];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                for (int k = 0; k < 4; k++) {
                    if (board[i][j][k] == 0) {
                        dfs(i, j, 1, k, grid);
                        pq.add(board[i][j][i]);
                    }
                }
            }
        }

        int[] res = new int[pq.size()];
        for (int i = pq.size() - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }

    private static void dfs(int y, int x, int cnt, int dir, String[] grid) {
        int ny, nx;
        int dirTmp = dir;
        if (grid[y].charAt(x) == 'S') {
            ny = y + dirs[dir][0];
            nx = x + dirs[dir][1];
        } else if (grid[y].charAt(x) == 'L') {
            ny = y + dirs[(dir + 1) % 4][0];
            nx = x + dirs[(dir + 1) % 4][1];
            dir = (dir + 1) % 4;
        } else {
            ny = y + dirs[dir - 1 == -1 ? 3 : dir - 1][0];
            nx = x + dirs[dir - 1 == -1 ? 3 : dir - 1][1];
            dir = dir - 1 == -1 ? 3 : dir - 1;
        }
        if (ny == -1)
            ny = grid.length - 1;
        if (nx == -1)
            nx = grid[0].length() - 1;
        if (ny == grid.length)
            ny = 0;
        if (nx == grid[0].length())
            nx = 0;

        if (board[ny][nx][dir] != 0) {
            board[ny][nx][dir] = cnt - 1;
            return;
        }
        board[ny][nx][dir] = cnt;

        dfs(ny, nx, cnt + 1, dir, grid);
    }
}
