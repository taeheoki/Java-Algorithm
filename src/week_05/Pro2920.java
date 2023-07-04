package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2920번 음계
 */
public class Pro2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pre = 0;
        boolean upFlag = false;
        boolean downFlag = false;
        for (int i = 0; i < 8; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (pre == 0) {
                pre = tmp;
                continue;
            }
            if (pre < tmp) {
                upFlag = true;
                pre = tmp;
            } else {
                downFlag = true;
                pre = tmp;
            }
        }
        if (upFlag && downFlag)
            System.out.println("mixed");
        else if (upFlag)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }
}
