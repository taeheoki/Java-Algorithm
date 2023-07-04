package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 백준 2908번 상수
 */
public class Pro2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int flag = 0;
        String A = st.nextToken();
        String B = st.nextToken();
        char[] newA = new char[3];
        char[] newB = new char[3];
        for (int i = 0; i < 3; i++) {
            newA[2 - i] = A.charAt(i);
            newB[2 - i] = B.charAt(i);
            if (newA[2 - i] > newB[2 - i])
                flag = 1;
            else if (newA[2 - i] < newB[2 - i])
                flag = 2;
        }
        System.out.println(flag == 1 ? newA : newB);
    }
}
