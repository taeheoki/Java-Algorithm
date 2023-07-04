package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 13144 - List of Unique Numbers
 * 문제 이해: 연속된 1개 이상의 수를 뽑았을 때, 같은 수가 여러 번 등장하지 않는 경우의 수
 * 시간 복잡도: O(2 * N) -> O(N)
 */
public class Pro13144 {
    static int N;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[100000 + 1];
        pro();
    }

    private static void pro() {
        long res = 0;
        int right = 0;
        for (int left = 1; left <= N; left++) {
            visit[arr[left - 1]] = false;
            while (right + 1 <= N) {
                right++;
                if (!visit[arr[right]]) {
                    visit[arr[right]] = true;
                } else {
                    right--;
                    break;
                }
           }
           res += right - left + 1;
        }
        System.out.println(res);
    }
}
