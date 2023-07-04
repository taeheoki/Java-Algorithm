package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 9934 - 완전 이진 트리
 * 문제 이해:
 * 시간 복잡도:
 */
public class Pro9934 {
    static BufferedReader br;
    static  StringTokenizer st;
    static StringBuilder[] sbs;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2, K) - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sbs = new StringBuilder[K];
        for (int i = 0; i < K; i++) {
            sbs[i] = new StringBuilder();
        }
        rec_func(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++) {
            System.out.println(sbs[i]);
        }
    }

    private static void rec_func(int s, int e, int floor) {
        if (floor == K)
            return;

        int mid = (s + e) / 2;
        sbs[floor].append(arr[mid]).append(" ");
        rec_func(s, mid - 1, floor + 1);
        rec_func(mid + 1, e, floor + 1);
    }

}
