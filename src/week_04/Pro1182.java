package src.week_04;

import java.io.*;
import java.util.*;

/**
 * 백준 1182번 부분수열의 합
 */
public class Pro1182 {
    static int N, S, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        rec_func(0, 0);
        if (S == 0)
            cnt--;
        System.out.println(cnt);
    }

    private static void rec_func(int depth, int sum) {
        if (depth == N) {
            if (sum == S)
                cnt++;
        } else {
            rec_func(depth + 1, sum);
            rec_func(depth + 1, sum + arr[depth]);
        }
    }
}
