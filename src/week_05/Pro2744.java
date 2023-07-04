package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2744번 대소문자 바꾸기
 */
public class Pro2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] dest = new char[word.length()];
        for (int i = 0; i< word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) >= 'Z')
                dest[i] = (char) (word.charAt(i) - 32);
            else {
                dest[i] = (char) (word.charAt(i) + 32);
            }
        }
        System.out.println(dest);
    }
}
