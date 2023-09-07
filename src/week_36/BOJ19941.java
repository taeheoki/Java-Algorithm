package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 19941 - 햄버거 분배
 */
public class BOJ19941 {
    static int N, K, res;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String tmp = br.readLine();
        arr = tmp.toCharArray();

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                for (int j = i - K; j <= i + K; j++) {
                    if (j < 0 || j >= N)
                        continue;
                    if (arr[j] == 'H') {
                        res++;
                        arr[j] = ' ';
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
