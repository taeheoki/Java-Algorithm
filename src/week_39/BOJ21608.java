package src.week_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 21608 - 상어 초등학교
 */
public class BOJ21608 {
    static int N;
    static int[] scores = {0, 1, 10, 100, 1000};
    static int[][] board, friends, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        friends = new int[N * N + 1][4];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++)
                friends[num][j] = Integer.parseInt(st.nextToken());
            pro(num);
        }

        System.out.println(score());
    }

    private static int score() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int[] dir : dirs) {
                    int ny = i + dir[0];
                    int nx = j + dir[1];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                        continue;
                    for (int k = 0; k < 4; k++) {
                        if (friends[board[i][j]][k] == board[ny][nx])
                            cnt++;
                    }
                }
                sum += scores[cnt];
            }
        }
        return sum;
    }

    private static void pro(int num) {
        // 인접한 칸에 있는 좋아하는 학생 수
        int max = -1;

        // 인접한 칸이 비어있는 수
        int vacant = -1;

        // 배정할 위치
        int seatY = -1;
        int seatX = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0)
                    continue;

                int cnt = 0;
                int vCnt = 0;

                for (int[] dir : dirs) {
                    int ny = i + dir[0];
                    int nx = j + dir[1];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                        continue;

                    for (int k = 0; k < 4; k++) {
                        if (friends[num][k] == board[ny][nx])
                            cnt++;
                    }

                    if (board[ny][nx] == 0)
                        vCnt++;
                }

                // 현재 칸에 인접한 좋아하는 학생 수가 max보다 많을 경우
                if (max < cnt) {
                    max = cnt;
                    seatY = i;
                    seatX = j;
                    vacant= vCnt;
                } else if (max == cnt && vacant< vCnt) {
                    // 좋아하는 학생 수가 같을 때, 더 많은 빈 자리가 있는 경우
                    seatY= i;
                    seatX= j;
                    vacant= vCnt;
                }
            }
        }

        board[seatY][seatX] = num;
    }


}
