package src.week_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 16508 - 전공책
 */
public class Pro16508 {
    static String T;
    static int N, res = Integer.MAX_VALUE;
    static int[] costArr;
    static String[] titleArr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        N = Integer.parseInt(br.readLine());
        costArr = new int[N];
        titleArr = new String[N];
        used = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costArr[i] = Integer.parseInt(st.nextToken());
            titleArr[i] = st.nextToken();
        }
        rec_func(0, 0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void rec_func(int depth, int cost) {
        if (depth == T.length()) {
            res = Math.min(res, cost);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (cost >= res) return;        // Pruning: 비용이 이미 발견된 값보다 크거나 같다면 종료

            String cmp = T.substring(depth, depth + 1);
            if (titleArr[i].contains(cmp)) {

                titleArr[i] = titleArr[i].replaceFirst(cmp, String.valueOf((char) (T.charAt(depth) + 32)));
                if (used[i]) {
                    rec_func(depth + 1, cost);
                } else {
                    used[i] = true;
                    rec_func(depth + 1, cost + costArr[i]);
                    used[i] = false;
                }
                titleArr[i] = titleArr[i].replaceFirst(String.valueOf((char) (T.charAt(depth) + 32)), cmp);
            }
        }
    }
}
