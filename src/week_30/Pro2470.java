package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2470 - 두 용액
 */
public class Pro2470 {
    static int N;
    static int[] arr, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        int diff = Integer.MAX_VALUE;
        res = new int[]{arr[left], arr[right]};
        while (left < right) {
            int tmp = arr[right] + arr[left];
            if (diff > Math.abs(tmp)) {
                res[0] = arr[left];
                res[1] = arr[right];
                diff = Math.abs(tmp);
            }
            if (tmp == 0)
                break;
            else if (tmp > 0)
                right--;
            else
                left++;
        }
        System.out.println(res[0] + " " + res[1]);
    }
}
