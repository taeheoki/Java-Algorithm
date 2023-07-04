package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2230 - 수 고르기
 * 문제 이해: 두 수를 골랐을 때(같은 수일 수도 있음), 그 차이가 M 이상이면서 제일 작은 경우를 구하라
 *          예를 들어 {1, 2, 3, 4, 5}, M = 3일 때
 *          1-4 -> 3, 1-5 -> 4, 2-5 -> 3 으로 3이 제일 작은 경우가 된다.
 * 시간 복잡도: 정렬 후 투 포인터
 *           O(NlogN)
 */
public class Pro2230 {
    static int N, M, res = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        pro();
    }

    private static void pro() {
        int right = 0;
        for (int left = 0; left < N; left++) {
            int diff = arr[right] - arr[left];
            while (diff < M && right + 1 < N) {
                right++;
                diff = arr[right] - arr[left];
            }
            if (diff >= M)
                res = Math.min(res, diff);
        }
        System.out.println(res);
    }
}
