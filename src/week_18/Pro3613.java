package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 3613 - Java vs C++
 */
public class Pro3613 {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        if (str.charAt(str.length() - 1) == '_')
            str = "Error!";
        else if (str.charAt(0) == '_')
            str = "Error!";
        else if (str.contains("__"))
            str = "Error!";
        else if (isUppercase(str.charAt(0)))
            str = "Error!";
        else {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.equals(str) && str.contains("_"))
                str = "Error!";
            else if (!lowerCase.equals(str)) {
                for (int idx = str.length() - 1; idx >= 0; idx--) {
                    char tmp = str.charAt(idx);
                    if (isUppercase(tmp)) {
                        str = str.replace(str.substring(idx, idx + 1), "_" + (char) (str.charAt(idx) + 32));
                    }
                }
            } else {
                int idx;
                while ((idx = str.indexOf("_")) != -1) {
                    str = str.replace(str.substring(idx, idx + 2), (char) (str.charAt(idx + 1) - 32) + "");
                }

            }
        }
        System.out.println(str);
    }

    private static boolean isUppercase(char tmp) {
        if (tmp >= 'A' && tmp <= 'Z')
            return true;
        return false;
    }
}
