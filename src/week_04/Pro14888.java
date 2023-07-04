package src.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 14888번 연산자 끼워넣기
 */
public class Pro14888 {
    static ArrayList<Integer> res = new ArrayList<>();
    static int[] arr, op = new int[4];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            op[i] = Integer.parseInt(st.nextToken());
        rec_func(0, arr[0]);
        Collections.sort(res);
        System.out.println(res.get(res.size() - 1));
        System.out.println(res.get(0));
    }

    private static void rec_func(int depth, int sum) {
        if (depth == N - 1) {
            res.add(sum);
        } else {
            for (int i = 0; i < 4; i++) {
                if (op[i] == 0)
                    continue;
                op[i]--;
                int tmp = calc(sum, arr[depth + 1], i);
                rec_func(depth + 1, tmp);
                op[i]++;
            }
        }
    }

    private static int calc(int num1, int num2, int op) {
        int tmp = 0;
        switch (op) {
            case 0:
                tmp = num1 + num2;
                break;
            case 1:
                tmp = num1 - num2;
                break;
            case 2:
                tmp = num1 * num2;
                break;
            case 3:
                tmp = num1 / num2;
                break;
        }
        return tmp;
    }
}
