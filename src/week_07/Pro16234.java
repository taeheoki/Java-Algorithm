package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * BOJ 16234 - 인구 이동
 * 문제 이해: 인접하고 있는 나라의 인구 수 차이가 L 이상 R 이하일 경우 국경이 열리고
 *          인구 이동이 시작된다. (A + B + ...) / Count(A + B + ...)
 *          인구 이동이 완전히 끝나는 날짜를 출력하라.
 * 시간 복잡도: O(N^2 * time);
 */
public class Pro16234 {
    static int N, L, R, time;
    static int[][] map, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static ArrayList<ArrayList<Elem>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[N][N];
        while (true) {
            // 단순히 인구 이동이 가능한 나라끼리 배열로 표현
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        ArrayList<Elem> tmp = new ArrayList<>();
                        dfs(i, j, tmp);
                        arr.add(tmp);
                    }
                }
            }
            // 인구 이동이 일어나지 않을 조건
            if (arr.size() == N * N)
                break;
            // 시간에 흐름에 따라 인구 변화를 표현
            for (int i = 0; i < arr.size(); i++) {
                Iterator<Elem> iterator = arr.get(i).iterator();
                int sum = 0;
                while (iterator.hasNext())
                    sum += iterator.next().population;
                for (int j = 0; j < arr.get(i).size(); j++) {
                    int x = arr.get(i).get(j).x;
                    int y = arr.get(i).get(j).y;
                    map[y][x] = sum / arr.get(i).size();
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visit[i][j] = false;
//                System.out.print(map[i][j] + " ");
                }
//            System.out.println();
            }
            time++;
            arr.clear();
        }
        System.out.println(time);
    }

    private static void dfs(int y, int x, ArrayList<Elem> adj) {
        visit[y][x] = true;
        adj.add(new Elem(x, y, map[y][x]));

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;
            if (visit[ny][nx])
                continue;
            int pTmp = Math.abs(map[ny][nx] - map[y][x]);
            if (pTmp < L || pTmp > R)
                continue;
            dfs(ny, nx, adj);
        }
    }

    public static class Elem {
        int x;
        int y;
        int population;

        public Elem(int x, int y, int population) {
            this.x = x;
            this.y = y;
            this.population = population;
        }
    }
}
