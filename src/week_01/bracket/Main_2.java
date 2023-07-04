package src.week_01.bracket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0, j = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char arr[] = br.readLine().toCharArray();
            if (arr[0] == ')')
                sb.append("NO").append("\n");
            else {
                for (j = 0; j < arr.length; j++) {
                    if (arr[j] == '(')
                        cnt++;
                    else if (arr[j] == ')') {
                        cnt--;
                    }

                    if (cnt < 0) {
                        sb.append("NO").append("\n");
                        break;
                    }
                }

                if (j == arr.length) {
                    if (cnt == 0)
                        sb.append("YES\n");
                    else
                        sb.append("NO\n");
                }
            }
            cnt = 0;
        }
        System.out.println(sb);
    }
}
