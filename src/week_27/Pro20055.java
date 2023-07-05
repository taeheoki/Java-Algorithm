package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 20055 - 컨베이어 벨트 위의 로봇
 */
public class Pro20055 {
    static int N, K;
    static int[] arr;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N * 2];
        robot = new boolean[N * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int cnt = 0;
        while (K > 0) {
            cnt++;
            for (int i = N - 1; i >= 0 ; i--) {
                int index = getIndex(i -cnt);
                if (i == N - 1) {
                    robot[index] = false;
                } else if (i == 0 && arr[index] != 0) {
                    robot[index] = true;
                    if (--arr[index] == 0)
                        K--;
                } else if (i > 0 && i < N - 1 && robot[index]) {
                    int next = (index + 1) % (2 * N);
                    if (!robot[next] && arr[next] != 0) {
                        robot[index] = false;
                        if (i != N - 2)
                            robot[next] = true;
                        if (--arr[next] == 0)
                            K--;
                    }
                }

            }
//            System.out.print(cnt + " : ");
//            for (int i = 0; i < 2 * N ; i++) {
//                int index = getIndex(i - cnt);
//                System.out.print(arr[index] + "(" + robot[index] + ")" + " ");
//            }
//            System.out.println();
//            if (Arrays.stream(arr).filter(n -> n == 0).count() == K)
//                break;
        }
        System.out.println(cnt);
    }

    private static int getIndex(int num) {
        if (num < 0) {
            /**
             * -1 -> 5
             * -2 -> 4
             * -3 -> 3
             * -4 -> 2
             * -5 -> 1
             * -6 -> 0
             * -7 -> 5
             */
            num = ((2 * N) - (num * -1) % (2 * N)) % (2 * N);
        }
        return num;
    }
}
