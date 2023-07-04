package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10799번
 */
public class Pro10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pipe = br.readLine();
        int checkPipe = 0;
        int pipeNum = 0;
        for (int i = 0; i < pipe.length(); i++) {
            char ch = pipe.charAt(i);
            if (ch == '(')
                checkPipe++;
            else if (ch == ')') {
                checkPipe--;
                if (pipe.charAt(i - 1) == '(')
                    pipeNum += checkPipe;
                else {
                    pipeNum++;
                }
            }
        }
        System.out.println(pipeNum);
    }
}
