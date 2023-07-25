package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 2469 - 사다리 타기
 */
public class Pro2469 {
    static int k, n, idx;
    static char[] source, dest;
    static char[][] opArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        dest = br.readLine().toCharArray();
        source = new char[k];
        for (int i = 0; i < k; i++) {
            source[i] = (char) ('A' + i);
        }
        opArr = new char[n][];
        for (int i = 0; i < n; i++) {
            opArr[i] = br.readLine().toCharArray();
            if (opArr[i][0] == '?')
                idx = i;
        }
        pro();
    }

    private static void pro() {
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < k - 1; j++) {
                if (opArr[i][j] == '-') {
                    swap(j, source);
                }
            }
        }
        for (int i = n - 1; i > idx; i--) {
            for (int j = 0; j < k - 1; j++) {
                if (opArr[i][j] == '-') {
                    swap(j, dest);
                }
            }
        }
        getQuestionLine();
    }

    private static void getQuestionLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            if (source[i] != dest[i]) {
                sb.append('-');
                swap(i, source);
            } else {
                sb.append('*');
            }
        }
        if (!Arrays.toString(source).equals(Arrays.toString(dest))) {
            sb = new StringBuilder();
            for (int i = 0; i < k - 1; i++) {
                sb.append('x');
            }
        }
        System.out.println(sb);
    }

    private static void swap(int index, char[] data) {
        char tmp = data[index];
        data[index] = data[index + 1];
        data[index + 1] = tmp;
    }
}
