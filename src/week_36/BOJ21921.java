package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 21921 - 블로그
 */
public class BOJ21921 {
    static int N, X;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int cnt = 0;
        int sum = 0;
        int maxSum = 0;
        int right = -1;
        int xCnt = X;
        for (int left = 0; left <= N - X; left++) {
            if (left != 0) {
                sum -= arr[left - 1];
                xCnt++;
            }
            while (xCnt > 0) {
                right++;
                sum += arr[right];
                xCnt--;
            }
            if (sum > maxSum) {
                cnt = 1;
                maxSum = sum;
            } else if (sum == maxSum) {
                cnt++;
            }
        }
        if (maxSum == 0)
            System.out.println("SAD");
        else {
            System.out.println(maxSum);
            System.out.println(cnt);
        }
    }
}
