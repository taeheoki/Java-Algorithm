package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * 백준 1157번 단어 공부
 */
public class Pro1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] used = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= 'a' && tmp <= 'z')
                tmp -= 32;
            used[tmp - 'A']++;
        }
        boolean flag = false;
        int max = -1;
        int index = -1;
        for (int i = 0; i < 26; i++) {
            if (max < used[i]) {
                max = used[i];
                index = i;
                flag = true;
            } else if (max == used[i]) {
                flag = false;
            }
        }
        System.out.println(flag? (char) (index + 'A'): "?");
    }
}
