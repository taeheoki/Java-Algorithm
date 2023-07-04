package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 22871번 징검다리 건너기 (large)
 * 시간 복잡도:
 */
public class Pro22871 {
    static int N, max = Integer.MIN_VALUE;
    static int[] arr;
    static boolean flag;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        long K = find_K();
        System.out.println(K);
    }

    private static long find_K() {
        long left = 0;
        long right = calc(0, N - 1);
        long res = 0;
        while (left <= right) {
            visited = new boolean[N];
            long mid = (left + right) / 2;
            flag = possible(0, mid);
            if (flag) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private static boolean possible(int cur, long mid) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        flag = false;
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (index == N - 1) {
                flag = true;
                break;
            }
            for (int i = index + 1; i < N; i++) {
                long tmp = calc(index, i);
                if (mid >= tmp && !visited[i]) {
                    stack.add(i);
                    visited[i] = true;
                }
            }
        }
        return flag;
    }

    private static long calc(int i, int j) {
        return (long) (j - i) * (1 + Math.abs(arr[i] - arr[j]));
    }
}
