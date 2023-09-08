package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BOJ 17140 - 이차원 배열과 연산
 */
public class BOJ17140 {
    static int r, c, k;
    static int[][] board = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private static void pro() {

        int row = 2;
        int col = 2;

        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (true) {
            if (board[r][c] == k)
                break;
            if (cnt > 100) {
                cnt = -1;
                break;
            }
            int max = Integer.MIN_VALUE;
            if (row >= col) { // R 연산
                for (int i = 0; i <= row; i++) {
                    for (int j = 0; j <= col; j++) {
                        if (board[i][j] == 0)
                            continue;
                        map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                        board[i][j] = 0;
                    }
                    List<Integer> list = map.keySet().stream().collect(Collectors.toList());
                    Collections.sort(list, (a, b) -> {
                        int aValue = map.get(a);
                        int bValue = map.get(b);
                        if (aValue == bValue)
                            return a - b;
                        return aValue - bValue;
                    });

                    int colLength = 0;
                    for (int k = 0; k < map.size(); k++) {
                        board[i][k * 2] = list.get(k);
                        board[i][k * 2 + 1] = map.get(list.get(k));
                        colLength += 2;
                    }
                    max = Math.max(max, colLength);
                    map.clear();
                }
                col = Math.max(col, max);
            } else { // C 연산
                for (int i = 0; i <= col; i++) {
                    for (int j = 0; j <= row; j++) {
                        if (board[j][i] == 0)
                            continue;
                        map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
                        board[j][i] = 0;
                    }
                    List<Integer> list = map.keySet().stream().collect(Collectors.toList());
                    Collections.sort(list, (a, b) -> {
                        int aValue = map.get(a);
                        int bValue = map.get(b);
                        if (aValue == bValue)
                            return a - b;
                        return aValue - bValue;
                    });

                    int rowLength = 0;
                    for (int k = 0; k < map.size(); k++) {
                        board[k * 2][i] = list.get(k);
                        board[k * 2 + 1][i] = map.get(list.get(k));
                        rowLength += 2;
                    }
                    max = Math.max(max, rowLength);
                    map.clear();
                }
                row = Math.max(row, max);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
