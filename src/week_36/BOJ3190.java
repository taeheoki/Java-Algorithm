package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * BOJ 3190 - 뱀
 */
public class BOJ3190 {
    static int N, K, L;
    static int[][] board, dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Deque<int[]> snake = new LinkedList<>();
    static Elem[] orderList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            board[s][r] = 1;
        }
        L = Integer.parseInt(br.readLine());
        orderList = new Elem[L];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            orderList[i] = new Elem(time, dir);
        }
        pro();
    }

    private static void pro() {
        int time = 0;
        snake.add(new int[]{0, 0});
        board[0][0] = -1;
        int dir = 0;
        int orderIndex = 0;

        while (true) {
            time++;
            int[] cur = snake.peekLast();
            int ny = cur[0] + dirs[dir][0];
            int nx = cur[1] + dirs[dir][1];

            if (ny < 0 || nx < 0 || ny >= N | nx >= N)
                break;
            if (board[ny][nx] == -1)
                break;
            snake.add(new int[]{ny, nx});
            if (board[ny][nx] == 0) {
                int[] tail = snake.pollFirst();
                board[tail[0]][tail[1]] = 0;
            }
            board[ny][nx] = -1;
            if (orderIndex < L && orderList[orderIndex].time == time) {
                if (orderList[orderIndex].dir == 'D')
                    dir = (dir + 1) % 4;
                else
                    dir = (dir + 3) % 4;
                orderIndex++;
            }
        }
        System.out.println(time);
    }

    private static class Elem {
        int time;
        char dir;

        public Elem(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }
}
