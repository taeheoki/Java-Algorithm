package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1487 - 물건 팔기
 */
public class Pro1487 {
    static int N;
    static int[] costs, deliverys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        costs = new int[N];
        deliverys = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            deliverys[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int prevSum = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            int pivot = costs[i];
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (costs[j] >= pivot && pivot - deliverys[j] > 0) {
                    sum += pivot - deliverys[j];
                }
            }
            if (sum >= prevSum) {
                res = sum == prevSum ? Math.min(res, pivot) : pivot;
                prevSum = sum;
            }
        }
        System.out.println(res);
    }
}
