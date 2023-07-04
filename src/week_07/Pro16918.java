package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 16918 - 봄버맨
 * 문제 이해: 폭탄이 놓여져 있는 칸은 3초가 지난 뒤 터지고, 4방향으로 폭발이 이어진다.
 *          폭발이 되는 곳이 폭탄이 놓여 있더라도, 연쇄반응은 없다.
 *          0초 -> 3초 폭발 -> 4초 설치 -> 7초 폭발 -> 8초 설치 -> 11초 폭발
 *          2초 -> 5초 폭발 -> 6초 설치 -> 9초 폭발 -> 10초 설치 -> 13초 폭발
 * 시간 복잡도: O(R * C * N)
 */
public class Pro16918 {
    static StringBuilder sb = new StringBuilder();
    static int R, C, N;
    static int[][] bombTime, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        bombTime = new int[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if (tmp.charAt(j) == 'O')
                    bombTime[i][j] = 3;
            }
        }
        pro();
    }

    private static void pro() {
        int time = 0;
        while (time++ < N) {
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombTime[i][j] = time + 3;
                        }
                    }
                }
            } else if (time % 2 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombTime[i][j] == time) {
                            map[i][j] = '.';
                            for (int[] dir : dirs) {
                                int ni = i + dir[0];
                                int nj = j + dir[1];
                                if (ni < 0 || nj < 0 || ni >= R || nj >= C)
                                    continue;
                                if (map[ni][nj] == 'O' && bombTime[ni][nj] != time) {
                                    map[ni][nj] = '.';
                                    bombTime[ni][nj] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        print();
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                sb.append(map[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
