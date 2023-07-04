package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2473 - 세 용액
 * 문제 이해: 주어진 용액들 중 3가지를 섞어 0에 가장 가까운 용액을 선택하라.
 * 문제 이해: 정렬 후 왼쪽부터 오른쪽으로 투포인터 적용
 *          O(N^NlogN)
 */
public class Pro2473 {
    static int N;
    static long res = Long.MAX_VALUE;
    static long[] arr, v = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            long pivot = arr[i];
            int left = i + 1;
            int right = N - 1;
            long sum = arr[i];
            while (left < right) {
                long tmp = sum + arr[left] + arr[right];
                if (Math.abs(tmp) < res) {
                    res = Math.abs(tmp);
                    v[0] = pivot;
                    v[1] = arr[left];
                    v[2] = arr[right];
                }
                if (tmp >= 0)
                    right--;
                else
                    left++;
            }
        }
        System.out.println(v[0] + " " + v[1] + " " + v[2]);
    }
}
