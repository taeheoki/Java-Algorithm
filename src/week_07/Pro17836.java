package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 17836 - 공주님을 구해라!
 * 문제 이해: 용사가 공주를 구하기 위해 공주의 위치까지 가는데 최단 시간 T를 구하라. (정해진 시간 안에 못 구하면 "Fail" 출력)
 *          가는 길에 "그람"을 구할 경우 벽을 부수고 지나갈 수 있다.
 * 시간 복잡도: O(NM)
 */
public class Pro17836 {
    static int N, M, T;
    static int[][] map, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[N][M][2];
        int res = bfs(0, 0);
        if (res == -1)
            System.out.println("Fail");
        else
            System.out.println(res);
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0, false));
        visit[y][x][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.count > T)
                break;
            if (cur.y == N - 1 && cur.x == M - 1)
                return cur.count;

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!cur.isGram) { // 그람 없을 때
                        if (!visit[ny][nx][0] && map[ny][nx] == 0) {
                            queue.offer(new Node(nx, ny, cur.count + 1, cur.isGram));
                            visit[ny][nx][0] = true;
                        } else if (!visit[ny][nx][0] && map[ny][nx] == 2) {
                            queue.offer(new Node(nx, ny, cur.count + 1, true));
                            visit[ny][nx][1] = true;
                        }
                    } else { // 그람 있을 때
                        if (!visit[ny][nx][1]) {
                            queue.offer(new Node(nx, ny, cur.count + 1, cur.isGram));
                            visit[ny][nx][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static class Node {
        int x;
        int y;
        int count;
        boolean isGram;

        public Node(int x, int y, int count, boolean isGram) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isGram = isGram;
        }
    }
}
