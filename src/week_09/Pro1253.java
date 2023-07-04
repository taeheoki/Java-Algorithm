package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1253 - 좋다
 * 문제 이해:
 * 시간 복잡도:
 */
public class Pro1253 {
    static int N, res;
    static int[] arr;

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

        for (int i = 0; i < N; i++) {
            if (isPossible(i))
                res++;
        }
        System.out.println(res);
    }

    private static boolean isPossible(int target_idx) {
        int left = 0;
        int right = N - 1;
        int target = arr[target_idx];
        while (left < right) {
            if (left == target_idx) {
                left++;
            } else if (right == target_idx) {
                right--;
            } else {
                int sum = arr[left] + arr[right];
                if (target == sum)
                    return true;
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return false;
    }
}
