package src.week_15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 프렌즈4블록
 * 문제 이해:
 */
public class Pro프렌즈4블록 {

    public static void main(String[] args) {
//        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
//        System.out.println(solution(6, 6, new String[]{"AAAAAA", "AAAAAA", "AABBAA", "AABCAA", "AAAAAA", "AAAAAA"}));
//        System.out.println(solution(4, 4, new String[]{"ACBA", "ACAA", "CAAA", "CAAA"}));
    }

    public static int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        do {
            while (!que.isEmpty()) {
                cnt += transform(map, que);
            }
            rearrange(map, m , n);
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != ' ' && ckeckBlock(map, i, j)) {
                        que.add(i);
                        que.add(j);
                    }
                }
            }
        } while (que.size() != 0);
        return cnt;
    }

    private static void rearrange(char[][] map, int m, int n) {
        for (int i = m - 1; i >= 1; i--) {
            for (int j = 0; j < n; j++) {
                int pos = 0;
                while (i + pos < m && map[i + pos][j] == ' ' && map[i - 1 + pos][j] != ' ') {
                    map[i + pos][j] = map[i - 1 + pos][j];
                    map[i - 1 + pos][j] = ' ';
                    pos++;
                }
            }
        }
    }

    private static int transform(char[][] map, Queue<Integer> que) {
        int cur_i = que.poll();
        int cur_j = que.poll();
        int cnt = 0;
        if (map[cur_i][cur_j] != ' ') {
            map[cur_i][cur_j] = ' ';
            cnt++;
        }
        if (map[cur_i + 1][cur_j] != ' ') {
            map[cur_i + 1][cur_j] = ' ';
            cnt++;
        }
        if (map[cur_i][cur_j + 1] != ' ') {
            map[cur_i][cur_j + 1] = ' ';
            cnt++;
        }
        if (map[cur_i + 1][cur_j + 1] != ' ') {
            map[cur_i + 1][cur_j + 1] = ' ';
            cnt++;
        }
        return cnt;
    }

    private static boolean ckeckBlock(char[][] map, int i, int j) {
        if ((map[i][j] == map[i + 1][j]) && (map[i][j] == map[i][j + 1]) && (map[i][j] == map[i + 1][j + 1]))
            return true;
        return false;
    }
}
