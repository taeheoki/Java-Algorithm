package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1254 - 팰린드롬 만들기
 */
public class Pro1254 {
    static String str;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        pro();
    }

    private static void pro() {
        int length = str.length();
        arr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            arr[i] = str.charAt(i);
        }

        int cnt = 0;
        while (!isPalindrome(length + cnt)) {
            cnt++;
            for (int i = 0; i < cnt; i++) {
                arr[(length - 1) + cnt - i] = arr[i];
            }
        }
        System.out.println(length + cnt);
    }

    private static boolean isPalindrome(int length) {
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            if (arr[left] != arr[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
