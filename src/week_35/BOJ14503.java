package src.week_35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 14503 - 로봇 청소기
 */
public class BOJ14503 {
    static int N, M, r, c, d, res;
    static int[][] room, dirs ={{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(r);
        que.add(c);

        int a = 1;
        while (!que.isEmpty()) {
            boolean flag = false;
            int y = que.poll();
            int x = que.poll();

            // 1번 과정
            if (room[y][x] == 0) {
                room[y][x] = ++a;
                cnt++;
            }

            // 3번 과정으로 청소되지 않은 칸 확인 후 전진
            int nd = d;
            for (int i = 0; i < 4; i++) {
                // 반시계 90 전환
                if (nd == 0) {
                    nd = 3;
                } else if (nd == 1) {
                    nd = 0;
                } else if (nd == 2) {
                    nd = 1;
                } else if (nd == 3) {
                    nd = 2;
                }
                int ny = y + dirs[nd][0];
                int nx = x + dirs[nd][1];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                    continue;
                if (room[ny][nx] == 0) {
                    d = nd;
                    que.add(ny);
                    que.add(nx);
                    flag = true;
                    break;
                }
            }
            // 2번 과정
            if (!flag) {
                int ny = y - dirs[d][0];
                int nx = x - dirs[d][1];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || room[ny][nx] == 1)
                    break;
                que.add(ny);
                que.add(nx);
            }
        }
        return cnt;
    }
}
