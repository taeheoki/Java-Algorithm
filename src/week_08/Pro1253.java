package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1253 - 좋다
 * 문제 이해:
 * 시간 복잡도: O(N^2)
 */
public class Pro1253 {
    static int N;
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
        // 최소, 최대를 빠르게 알기 위한 정렬
        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            // i 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
            if (func(i))
                ans++;
        }
        System.out.println(ans);
    }

    // target_idx 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
    private static boolean func(int target_idx) {
        int left = 0, right = N - 1;
        int target = arr[target_idx];
        while (left < right) {
            if (left == target_idx)
                left++;
            else if (right == target_idx)
                right--;
            else {
                int sum = arr[left] + arr[right];
                if (target == sum)
                    return true;
                if (sum > target)
                    right--;
                else
                    left++;
            }
        }
        return false;
    }
}
