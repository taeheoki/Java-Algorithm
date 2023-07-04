package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * BOJ 17255 - N으로 만들기
 */
public class Pro17255 {
    static String N;
    static char[] arr;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        arr = N.toCharArray();
        set = new HashSet<>();
        for (int i = 0; i < N.length(); i++) {
            rec_func(i, i, arr[i] + "", arr[i] + "");
        }
        System.out.println(set);
    }

    private static void rec_func(int L, int R, String s, String path) {
        if (L == 0 && R == arr.length - 1) {
            set.add(path);
            return;
        }
        if (L - 1 >= 0) {
            rec_func(L - 1, R, arr[L - 1] + s, path + " " + arr[L - 1] + s);
        }
        if (R + 1 < arr.length) {
            rec_func(L, R + 1, s + arr[R + 1], path + " " + s + arr[R + 1]);
        }
    }
}
