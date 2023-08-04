package src.week_31;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 프로그래머스 - 표 병합
 */
public class Pro150366 {

    static class Solution {

        static String[][] board = new String[50 + 1][50 + 1];
        static int[][] mergeTable = new int[50 + 1][50 + 1], dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        static ArrayList<String> arr = new ArrayList<>();

        public String[] solution(String[] commands) {
            int n = 1;
            for (String command : commands) {
                StringTokenizer st = new StringTokenizer(command);
                String cmd = st.nextToken();
                if (cmd.equals("UPDATE")) {
                    if (st.countTokens() == 3) {
                        int r = Integer.parseInt(st.nextToken());
                        int c = Integer.parseInt(st.nextToken());
                        String value = st.nextToken();
                        if (mergeTable[r][c] == 0) {
                            board[r][c] = value;
                        } else {
                            for (int i = 1; i <= 50; i++) {
                                for (int j = 1; j <= 50; j++) {
                                    if (mergeTable[i][j] == mergeTable[r][c])
                                        board[i][j] = value;
                                }
                            }
                        }
                    } else {
                        String source = st.nextToken();
                        String dest = st.nextToken();
                        for (int i = 1; i <= 50; i++) {
                            for (int j = 1; j <= 50; j++) {
                                if (board[i][j] != null && board[i][j].equals(source))
                                    board[i][j] = dest;
                            }
                        }
                    }
                } else if (cmd.equals("MERGE")) {
                    int r1 = Integer.parseInt(st.nextToken());
                    int c1 = Integer.parseInt(st.nextToken());
                    int r2 = Integer.parseInt(st.nextToken());
                    int c2 = Integer.parseInt(st.nextToken());
                    if (r1 == r2 && c1 == c2)
                        continue;
                    String tmp = board[r1][c1];
                    if (tmp == null)
                        tmp = board[r2][c2];
                    if (mergeTable[r1][c1] == 0 && mergeTable[r2][c2] == 0) {
                        mergeTable[r1][c1] = n;
                        mergeTable[r2][c2] = n;
                        board[r2][c2] = tmp;
                        n++;
                    } else if (mergeTable[r1][c1] == 0 && mergeTable[r2][c2] != 0) {
                        int pivot = mergeTable[r2][c2];
                        mergeTable[r1][c1] = n;
                        for (int i = 1; i <= 50; i++) {
                            for (int j = 1; j <= 50; j++) {
                                if (mergeTable[i][j] == pivot) {
                                    mergeTable[i][j] = n;
                                    board[i][j] = tmp;
                                }
                            }
                        }
                        n++;
                    } else if (mergeTable[r1][c1] != 0 && mergeTable[r2][c2] == 0) {
                        mergeTable[r2][c2] = mergeTable[r1][c1];
                        board[r2][c2] = tmp;
                    } else if (mergeTable[r1][c1] != 0 && mergeTable[r2][c2] != 0) {
                        int pivot = mergeTable[r2][c2];
                        for (int i = 1; i <= 50; i++) {
                            for (int j = 1; j <= 50; j++) {
                                if (mergeTable[i][j] == pivot) {
                                    mergeTable[i][j] = mergeTable[r1][c1];
                                    board[i][j] = tmp;
                                }
                            }
                        }
                    }
                } else if (cmd.equals("UNMERGE")) {
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    int pivot = mergeTable[r][c];
                    if (pivot == 0)
                        continue;
                    mergeTable[r][c] = 0;
                    for (int i = 1; i <= 50; i++) {
                        for (int j = 1; j <= 50; j++) {
                            if (mergeTable[i][j] == pivot) {
                                board[i][j] = null;
                                mergeTable[i][j] = 0;
                            }
                        }
                    }
                } else if (cmd.equals("PRINT")) {
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    arr.add(board[r][c] == null ? "EMPTY" : board[r][c]);
                }
            }
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 4; j++) {
                    System.out.print(board[i][j] + "\t");
                }
                System.out.println();
            }
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 4; j++) {
                    System.out.print(mergeTable[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(arr);
            return arr.toArray(new String[0]);
        }
    }
}
