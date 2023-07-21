package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 12933 - 오리
 */
public class Pro12933 {
    static int res;
    static int[] arr = new int[5]; // quack
    static String sound;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sound = br.readLine();
        if (sound.length() % 5 == 0) {
            for (int i = 0; i < sound.length(); i++) {
                char tmp = sound.charAt(i);
                if (tmp == 'q') {
                    arr[0]++;
                } else if (tmp == 'u') {
                    if (arr[0] > arr[1])
                        arr[1]++;
                    else {
                        res = 0;
                        break;
                    }
                } else if (tmp == 'a') {
                    if (arr[1] > arr[2])
                        arr[2]++;
                    else {
                        res = 0;
                        break;
                    }
                } else if (tmp == 'c') {
                    if (arr[2] > arr[3])
                        arr[3]++;
                    else {
                        res = 0;
                        break;
                    }
                } else if (tmp == 'k') {
                    if (arr[3] > arr[4]) {
                        res = Math.max(res, arr[0]);
                        arr[0]--;
                        arr[1]--;
                        arr[2]--;
                        arr[3]--;
                    } else {
                        res = 0;
                        break;
                    }
                }
            }
        }
        System.out.println(res == 0 ? -1 : res);
    }
}
