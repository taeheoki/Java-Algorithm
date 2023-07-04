package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1940 - 주몽
 * 문제 이해: 갑옷을 만들기 위해 두 개의 재료를 합쳐서 M을 만드는데,
 *          가지고 있는 재료(N개)로 몇 개를 만들 수 있는지 알아보자.
 * 시간 복잡도: 정렬 + 2 * N -> O(NlogN)
 */
public class Pro1940 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        // 정렬
        Arrays.sort(arr);
        int cnt = 0;
        int left = 0;
        int right = N - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == M)
                cnt++;
            if (sum >= M)
                right--;
            else
                left++;
        }
        System.out.println(cnt);
    }
}
