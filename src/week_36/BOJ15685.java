package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 15685 - 드래곤 커브
 */
public class BOJ15685 {
    static int N;
    static int[][] map = new int[101][101], dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            draw(x, y, d, g);
        }

        int res = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1)
                    res++;
            }
        }
        System.out.println(res);
    }

    private static void draw(int x, int y, int d, int g) {
        map[x][y] = 1;

        ArrayList<Integer> dirList = new ArrayList<>();
        dirList.add(d);

        for (int i = 0; i < g; i++) {
            int size = dirList.size();
            for (int j = 0; j < size; j++) {
                int dir = dirList.get(size - j - 1) + 1;
                if (dir > 3)
                    dir = 0;
                dirList.add(dir);
            }
        }

        for (int i = 0; i < dirList.size(); i++) {
            x += dirs[dirList.get(i)][0];
            y += dirs[dirList.get(i)][1];
            map[x][y] = 1;
        }
    }
}
