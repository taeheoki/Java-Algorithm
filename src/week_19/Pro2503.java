package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2503 - 숫자 야구
 */
public class Pro2503 {
    static int N, res;
    static String[] arr;
    static int[] strike, ball;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        strike = new int[N];
        ball = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 123; i <= 987; i++) {
            int one = i % 10;
            int ten = (i % 100) / 10;
            int hundred = i / 100;
            if (one == ten || ten == hundred || hundred == one)
                continue;
            if (one == 0 || ten == 0 || hundred == 0)
                continue;
            for (int j = 0; j < N; j++) {
                int s = 0;
                int b = 0;
                if (arr[j].contains(String.valueOf(one))) {
                    if (arr[j].indexOf(String.valueOf(one)) == 2)
                        s++;
                    else
                        b++;
                }
                if (arr[j].contains(String.valueOf(ten))) {
                    if (arr[j].indexOf(String.valueOf(ten)) == 1)
                        s++;
                    else
                        b++;
                }
                if (arr[j].contains(String.valueOf(hundred))) {
                    if (arr[j].indexOf(String.valueOf(hundred)) == 0)
                        s++;
                    else
                        b++;
                }
                if (s != strike[j] || b != ball[j])
                    break;
                if (j == N - 1)
                    res++;
            }
        }
        System.out.println(res);
    }
}
