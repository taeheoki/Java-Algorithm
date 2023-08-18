package src.week_32;

import com.sun.security.jgss.GSSUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Pro87694 {

    public static final int SIZE = 100;
    static int res;
    static int[][] edgeDirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}},
            dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}, board;
    static boolean[][] visit;


    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7, 8));
        System.out.println(solution(new int[][]{{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}}, 9, 7, 6, 1));
        System.out.println(solution(new int[][]{{1, 1, 5, 7}}, 1, 1, 4, 7));
        System.out.println(solution(new int[][]{{2, 1, 7, 5}, {6, 4, 10, 10}}, 3, 1, 7, 10));
        System.out.println(solution(new int[][]{{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}}, 1, 4, 6, 3));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        board = new int[SIZE + 2][SIZE + 2];
        visit = new boolean[SIZE + 2][SIZE + 2];
        for (int i = 0; i < rectangle.length; i++) {
            int c1 = rectangle[i][0] * 2;
            int r1 = rectangle[i][1] * 2;
            int c2 = rectangle[i][2] * 2;
            int r2 = rectangle[i][3] * 2;
            for (int j = c1; j <= c2; j++) {
                for (int k = r1; k <= r2; k++) {
                    board[j][k] = 1;
                }
            }
        }

        dfs(0, 0);
        visit = new boolean[SIZE + 2][SIZE + 2];

//        for (int i = 0; i <= SIZE + 1; i++) {
//            for (int j = 0; j <= SIZE + 1; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        return bfs(characterX, characterY, itemX, itemY);
    }

    private static void dfs(int y, int x) {
        visit[y][x] = true;
        if (board[y][x] == 1) {
            board[y][x] = 2;
            return;
        }

        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];
            if (ny < 0 || nx < 0 || nx >= SIZE + 2 || ny >= SIZE + 2)
                continue;
            if (visit[ny][nx])
                continue;
//            if (board[ny][nx] == 1) {
//                board[ny][nx] = 2;
//                continue;
//            }
            dfs(ny, nx);
        }
    }

    private static int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Integer> que = new LinkedList<>();
        que.add(characterY * 2);
        que.add(characterX * 2);
        visit[characterY * 2][characterX * 2] = true;

        int cnt = 0;
        while (!que.isEmpty()) {
            int size = que.size() / 2;
            for (int i = 0; i < size; i++) {
                int y = que.poll();
                int x = que.poll();

                if (y == itemY * 2 && x == itemX * 2)
                    break;
                for (int[] dir : dirs) {
                    int ny = y + dir[0];
                    int nx = x + dir[1];
                    if (ny < 0 || nx < 0 || nx >= SIZE + 2 || ny >= SIZE + 2)
                        continue;
                    if (visit[ny][nx])
                        continue;
                    if (board[ny][nx] != 2)
                        continue;
                    visit[ny][nx] = true;
                    que.add(ny);
                    que.add(nx);
                }
            }
            cnt++;
        }
        return cnt / 2;
    }
}
