package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 3273 - 두 수의 합
 * 문제 이해: 두 수를 더해서 x를 만드는것을 만족하는 (a_i, a_j)의 쌍의 수를 구하라.
 * 시간 복잡도: O(NlogN + 2 * N) -> O(NlogN)
 */
public class Pro3273 {
    static int n, x;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        // 정렬
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int cnt = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x)
                cnt++;
            if (sum >= x)
                right--;
            else
                left++;
        }
        System.out.println(cnt);
    }
}
