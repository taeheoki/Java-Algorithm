package src.week_40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 4446 - ROT13
 */
public class BOJ4446 {
    static String words1 = "aiyeou";
    static String words2 = "AIYEOU";
    static String words3 = "bkxznhdcwgpvjqtsrlmf";
    static String words4 = "BKXZNHDCWGPVJQTSRLMF";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String src = null;
        while ((src = br.readLine()) != null) {
            char[] srcToChar = src.toCharArray();
            char[] dest = new char[src.length()];
            for (int i = 0; i < src.length(); i++) {
                dest[i] = transChar(srcToChar[i]);
            }
            System.out.println(dest);
        }
    }

    private static char transChar(char ch) {
        String strCh = Character.toString(ch);
        if (words1.contains(strCh)) {
            return words1.charAt((words1.indexOf(strCh) + 3) % 6);
        } else if (words2.contains(strCh)) {
            return words2.charAt((words2.indexOf(strCh) + 3) % 6);
        } else if (words3.contains(strCh)) {
            return words3.charAt((words3.indexOf(strCh) + 10) % 20);
        } else if (words4.contains(strCh)) {
            return words4.charAt((words4.indexOf(strCh) + 10) % 20);
        }
        return ch;
    }
}
