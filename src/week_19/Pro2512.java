package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2512 - 예산
 */
public class Pro2512 {
    static int N, M;
    static int[] cities;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cities = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        int left = 0;
        int right = Arrays.stream(cities).max().getAsInt();
        int res = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getBudget(mid, M)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(res);
    }

    private static boolean getBudget(int mid, int M) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (cities[i] > mid)
                sum += mid;
            else {
                sum += cities[i];
            }
            if (sum > M)
                return false;
        }
        return true;
    }
}
