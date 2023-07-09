package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 15918 - 랭퍼든 수열쟁이야!!
 */
public class Pro15918 {
    static int n, x, y, res;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr = new int[2 * n];
        used = new boolean[n + 1];
        arr[x - 1] = y - x - 1;
        arr[y - 1] = y - x - 1;
        used[y - x - 1] = true;
        rec_func(0);
        System.out.println(res);
    }

    private static void rec_func(int depth) {
        if (depth == 2 * n) {
            res++;
            return;
        }
        if (arr[depth] > 0) {
            rec_func(depth + 1);
            return;
        }
        for (int j = 1; j <= n; j++) {
            if (!used[j] && depth + j + 1 < 2 * n && arr[depth + j + 1] == 0) {
                arr[depth] = j;
                arr[depth + j + 1] = j;
                used[j] = true;
                rec_func(depth + 1);
                arr[depth] = 0;
                arr[depth + j + 1] = 0;
                used[j] = false;
            }
        }
    }
}
