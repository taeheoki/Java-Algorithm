package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ 2015 - 수들의 합 4
 */
public class Pro2015 {
    static int N, K;
    static int[] A, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + A[i];
        }
        pro();
    }

    private static void pro() {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= N; i++) {
            if (map.containsKey(sum[i] - K)) {
                res += map.get(sum[i] - K);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        System.out.println(res);
    }
}
