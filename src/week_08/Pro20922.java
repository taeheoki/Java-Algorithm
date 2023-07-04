package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOH 20922 - 겹치는 건 싫어
 * 문제 이해: N개의 원소가 주어졌을 때, 원소가 연속된 수열의 최장 길이를 구하라.
 *          K개 이하의 수열은 겹쳐도 괜찮다.
 * 시간 복잡도: O(N)
 */
public class Pro20922 {
    static int N, K, res;
    static int[] arr, visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt((st.nextToken()));
        }
        pro();
    }

    private static void pro() {
        visit = new int[100001];
        int right = 0;
        visit[arr[0]] = 1;
        int length = 1;
        for (int left = 1; left <= N; left++) {
            visit[arr[left - 1]]--;
            length--;
            while (visit[arr[right]] <= K && right + 1 <= N) {
                right++;
                visit[arr[right]]++;
                length++;
            }
            if (visit[arr[right]] > K)
                res = Math.max(res, length - 1);
            else
                res = Math.max(res, length);
        }
        System.out.println(res);
    }
}
