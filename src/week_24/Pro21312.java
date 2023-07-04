package src.week_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 21312 - 홀짝 칵테일
 */
public class Pro21312 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int odd = 1;
        int even = 1;
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            if (arr[i] % 2 == 0)
                even *= arr[i];
            else {
                flag = true;
                odd *= arr[i];
            }
        }
        System.out.println(flag ? odd : even);
    }
}
