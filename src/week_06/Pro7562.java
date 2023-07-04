package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 7562 - 나이트의 이동
 * 시간 복잡도: 정점 O(I^2), 간선 O(I^2 * 8)
 *           O(I^2)의 시간 복잡도를 가진다.
 */
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Pro7562 {

    static StringBuilder sb = new StringBuilder();
    static int T, I, cnt;
    static Point[] locations = new Point[2]; // 시작점과 끝점을 담는다.
    static int[][] dir = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 횟수
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
            visit = new boolean[I][I];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                locations[j] = new Point(x, y);
            }
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        cnt = 0;
        // 탐색에 들어가기 앞서 고민을 해보면 최소 이동 경로를 찾아야 하기 때문에 dfs를 쓸 경우 굉장히 큰 수가 나올 수 있다.
        // 작은 수가 나온다 하더라도 더 작은 수가 나올 수 있다는 가정하에 끝까지 코드를 돌리기 때문에 bfs가 적당하다고 생각된다.
        // bfs로 최소 이동으로 답을 찾아낼 수 있다.
        cnt = bfs();
        sb.append(cnt).append("\n");
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(locations[0].x, locations[0].y));
        visit[locations[0].x][locations[0].y] = true;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Point tmp = queue.poll();

                if (tmp.x == locations[1].x && tmp.y == locations[1].y)
                    return cnt;
                for (int[] tmpDir : dir) {
                    int nx = tmp.x + tmpDir[0];
                    int ny = tmp.y + tmpDir[1];
                    if (nx < 0 || ny < 0 || nx >= I || ny >= I)
                        continue;
                    if (visit[nx][ny])
                        continue;
                    queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
            cnt++;
//            1 -> 1 2 -> 1 2 3 4
//                 cnt++   cnt++
        }
        return 0;
    }
}
