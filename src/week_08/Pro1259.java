package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1259 - 팰린드롬수
 */
public class Pro1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            boolean flag = false;
            String data = br.readLine();
            if (data.equals("0"))
                break;
            int size = data.length() / 2;
            for (int i = 0; i < size; i++) {
              if (data.charAt(i) != data.charAt(data.length() - 1 - i)) {
                  flag = true;
                  break;
              }
            }
            if (flag)
                sb.append("no").append("\n");
            else
                sb.append("yes").append("\n");
        }
        System.out.println(sb);
    }
}
