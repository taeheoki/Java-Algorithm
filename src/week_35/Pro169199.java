package src.week_35;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 리코쳇 로봇
 */
public class Pro169199 {

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static char[][] copyBoard;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(solution(new String[]{".D.R", "....", ".G..", "...D"}));
        System.out.println(solution(new String[]{"..R", "...", "...", "..D", "DG."}));
    }

    public static int solution(String[] board) {
        int res = 0;
        copyBoard = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = board[i].toCharArray();
        }
        visited = new boolean[copyBoard.length][copyBoard[0].length];
        for (int i = 0; i < copyBoard.length; i++) {
            for (int j = 0; j < copyBoard[0].length; j++) {
                if (copyBoard[i][j] == 'R') {
                    visited[i][j] = true;
                    res = bfs(i, j);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int bfs(int i, int j) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        que.add(j);

        int cnt = -1;

        while (!que.isEmpty()) {
            int size = que.size() / 2;
            cnt++;
            for (int k = 0; k < size; k++) {
                int y = que.poll();
                int x = que.poll();

                if (copyBoard[y][x] == 'G')
                    return cnt;

                for (int[] dir : dirs) {
                    int[] res = getPosition(y, x, dir);
                    int ny = res[0];
                    int nx = res[1];
                    if (visited[ny][nx])
                        continue;
                    visited[ny][nx] = true;
                    que.add(ny);
                    que.add(nx);
                }
            }
        }
        return -1;
    }

    private static int[] getPosition(int y, int x, int[] dir) {
        int i = 0;
        boolean flag = false;
        while (copyBoard[y + dir[0] * i][x + dir[1] * i] != 'D') {
            i++;
            if (y + dir[0] * i < 0 || x + dir[1] * i < 0 || y + dir[0] * i >= copyBoard.length || x + dir[1] * i >= copyBoard[0].length) {
                flag = true;
                break;
            }
        }
        return new int[]{y + dir[0] * (i - 1), x + dir[1] * (i - 1)};
    }
}
