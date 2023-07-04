package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 2108 - 통계학
 */
public class Pro21078 {
    static int N, most_val;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        pro();
    }

    private static void pro() {
        Arrays.sort(arr);
        int avg = (int) Math.round((double) Arrays.stream(arr).sum() / N);
        int mid_val = arr[N / 2];
        int most_val = getMostVal();
        int distance = arr[N - 1] - arr[0];
        System.out.println(avg);
        System.out.println(mid_val);
        System.out.println(most_val);
        System.out.println(distance);
    }

    private static int getMostVal() {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (i != 0 && arr[i - 1] == arr[i])
                cnt++;
            else
                cnt = 1;
            res = Math.max(res, cnt);
        }
        int flag = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int tmp = res - 1;
            while (tmp > 0 && i + 1 < N && arr[i] == arr[i + 1]) {
                i++;
                tmp--;
            }
            if (tmp == 0) {
                flag++;
                ans = arr[i];
                if (flag == 2)
                    return ans;
            }
        }
        return ans;
    }
}
