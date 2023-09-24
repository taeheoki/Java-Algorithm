package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ1063 - 킹
 */
public class BOJ1063 {
    static StringBuilder sb = new StringBuilder();
    static int N, nyKingPos, nxKingPos, nyRockPos, nxRockPos;
    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingPosStr = st.nextToken();
        int[] kingPos = new int[]{kingPosStr.charAt(1) - '1', kingPosStr.charAt(0) - 'A'};
        String rockPosStr = st.nextToken();
        int[] rockPos = new int[]{rockPosStr.charAt(1) - '1', rockPosStr.charAt(0) - 'A'};
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String cmp = br.readLine();
            nyRockPos = rockPos[0];
            nxRockPos = rockPos[1];
            if (cmp.equals("R")) {
                nyKingPos = kingPos[0] + dirs[0][0];
                nxKingPos = kingPos[1] + dirs[0][1];
                if (nyKingPos == rockPos[0] && nxKingPos == rockPos[1]) {
                    nyRockPos = rockPos[0] + dirs[0][0];
                    nxRockPos = rockPos[1] + dirs[0][1];
                }
                if (nyKingPos < 0 || nxKingPos < 0 || nyKingPos >= 8 || nxKingPos >= 8 ||
                        nyRockPos < 0 || nxRockPos < 0 || nyRockPos >= 8 || nxRockPos >= 8)
                    continue;
            } else if (cmp.equals("L")) {
                nyKingPos = kingPos[0] + dirs[1][0];
                nxKingPos = kingPos[1] + dirs[1][1];
                if (nyKingPos == rockPos[0] && nxKingPos == rockPos[1]) {
                    nyRockPos = rockPos[0] + dirs[1][0];
                    nxRockPos = rockPos[1] + dirs[1][1];
                }
                if (nyKingPos < 0 || nxKingPos < 0 || nyKingPos >= 8 || nxKingPos >= 8 ||
                        nyRockPos < 0 || nxRockPos < 0 || nyRockPos >= 8 || nxRockPos >= 8)
                    continue;
            } else if (cmp.equals("B")) {
                nyKingPos = kingPos[0] + dirs[2][0];
                nxKingPos = kingPos[1] + dirs[2][1];
                if (nyKingPos == rockPos[0] && nxKingPos == rockPos[1]) {
                    nyRockPos = rockPos[0] + dirs[2][0];
                    nxRockPos = rockPos[1] + dirs[2][1];
                }
                if (nyKingPos < 0 || nxKingPos < 0 || nyKingPos >= 8 || nxKingPos >= 8 ||
                        nyRockPos < 0 || nxRockPos < 0 || nyRockPos >= 8 || nxRockPos >= 8)
                    continue;
            } else if (cmp.equals("T")) {
                nyKingPos = kingPos[0] + dirs[3][0];
                nxKingPos = kingPos[1] + dirs[3][1];
                if (nyKingPos == rockPos[0] && nxKingPos == rockPos[1]) {
                    nyRockPos = rockPos[0] + dirs[3][0];
                    nxRockPos = rockPos[1] + dirs[3][1];
                }
                if (nyKingPos < 0 || nxKingPos < 0 || nyKingPos >= 8 || nxKingPos >= 8 ||
                        nyRockPos < 0 || nxRockPos < 0 || nyRockPos >= 8 || nxRockPos >= 8)
                    continue;
            } else if (cmp.equals("RT")) {
                nyKingPos = kingPos[0] + dirs[4][0];
                nxKingPos = kingPos[1] + dirs[4][1];
                if (nyKingPos == rockPos[0] && nxKingPos == rockPos[1]) {
                    nyRockPos = rockPos[0] + dirs[4][0];
                    nxRockPos = rockPos[1] + dirs[4][1];
                }
                if (nyKingPos < 0 || nxKingPos < 0 || nyKingPos >= 8 || nxKingPos >= 8 ||
                        nyRockPos < 0 || nxRockPos < 0 || nyRockPos >= 8 || nxRockPos >= 8)
                    continue;
            } else if (cmp.equals("LT")) {
                nyKingPos = kingPos[0] + dirs[5][0];
                nxKingPos = kingPos[1] + dirs[5][1];
                if (nyKingPos == rockPos[0] && nxKingPos == rockPos[1]) {
                    nyRockPos = rockPos[0] + dirs[5][0];
                    nxRockPos = rockPos[1] + dirs[5][1];
                }
                if (nyKingPos < 0 || nxKingPos < 0 || nyKingPos >= 8 || nxKingPos >= 8 ||
                        nyRockPos < 0 || nxRockPos < 0 || nyRockPos >= 8 || nxRockPos >= 8)
                    continue;
            } else if (cmp.equals("RB")) {
                nyKingPos = kingPos[0] + dirs[6][0];
                nxKingPos = kingPos[1] + dirs[6][1];
                if (nyKingPos == rockPos[0] && nxKingPos == rockPos[1]) {
                    nyRockPos = rockPos[0] + dirs[6][0];
                    nxRockPos = rockPos[1] + dirs[6][1];
                }
                if (nyKingPos < 0 || nxKingPos < 0 || nyKingPos >= 8 || nxKingPos >= 8 ||
                        nyRockPos < 0 || nxRockPos < 0 || nyRockPos >= 8 || nxRockPos >= 8)
                    continue;
            } else if (cmp.equals("LB")) {
                nyKingPos = kingPos[0] + dirs[7][0];
                nxKingPos = kingPos[1] + dirs[7][1];
                if (nyKingPos == rockPos[0] && nxKingPos == rockPos[1]) {
                    nyRockPos = rockPos[0] + dirs[7][0];
                    nxRockPos = rockPos[1] + dirs[7][1];
                }
                if (nyKingPos < 0 || nxKingPos < 0 || nyKingPos >= 8 || nxKingPos >= 8 ||
                        nyRockPos < 0 || nxRockPos < 0 || nyRockPos >= 8 || nxRockPos >= 8)
                    continue;
            }
            kingPos[0] = nyKingPos;
            kingPos[1] = nxKingPos;
            rockPos[0] = nyRockPos;
            rockPos[1] = nxRockPos;
        }
        sb.append((char) (kingPos[1] + 'A')).append((char) (kingPos[0] + '1')).append('\n');
        sb.append((char) (rockPos[1] + 'A')).append((char) (rockPos[0] + '1')).append('\n');
        System.out.println(sb);
    }
}
