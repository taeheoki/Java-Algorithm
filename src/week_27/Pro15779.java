package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 15779 - Zigzag
 */
public class Pro15779 {
    static int N, res;
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
        for (int i = 0; i < N; i++) {
            int cnt = 2;
            if (i + 1 >= N)
                break;
            boolean flag = arr[i] > arr[i + 1];
            boolean isEqual = false;
            if (arr[i] == arr[i + 1])
                isEqual = true;
            for (int j = i + 2; j < N; j++) {
                if (isEqual)
                    break;
                if (flag) {
                    if (arr[j - 1] > arr[j])
                        break;
                    if (arr[j - 1] == arr[j])
                        break;
                    flag = false;
                    cnt++;
                } else {
                    if (arr[j - 1] < arr[j])
                        break;
                    if (arr[j - 1] == arr[j])
                        break;
                    flag = true;
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        System.out.println(res);
    }
}
