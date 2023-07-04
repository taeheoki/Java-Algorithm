package src.week_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 15918 - 랭퍼든 수열쟁이야!!
 */
public class Pro15918 {
    static int n, x, y, res;
    static boolean[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr = new boolean[2 * n];
        used = new boolean[n];
        arr[x - 1] = true;
        arr[y - 1] = true;
        used[y - x - 1] = true;
        rec_func(0);

    }

    private static void rec_func(int depth) {
        if (depth == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {

        }
    }
}
