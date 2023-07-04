package src.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 21919 - 소수 최소 공배수
 * 문제 이해: 주어진 수열에서 소수들을 골라 최소 공배수를 구한다.
 *          만약 소수가 없다면 -1을 출력한다.
 */
public class Pro21919 {
    static int N;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new boolean[1000000];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (visit[arr[i]])
                arr[i] = 1;
            else
                visit[arr[i]] = true;
        }
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    arr[i] = 1;
                    break;
                }
            }
        }
        long res = 1;
        for (int j = 0; j < N; j++) {
            res *= arr[j];
        }
        System.out.println(res == 1 ? -1 : res);
    }
}
