package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1107 - 리모컨
 */
public class Pro1107 {
//    static int N, M;
//    static boolean[] arr;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        M = Integer.parseInt(br.readLine());
//        arr = new boolean[10];
//        if (M > 0) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int i = 0; i < M; i++) {
//                arr[Integer.parseInt(st.nextToken())] = true;
//            }
//        }
//        pro();
//    }
//
//    private static void pro() {
//        int res = Math.abs(N - 100);
//        for (int i = 0; i <= 999999; i++) {
//            String str = String.valueOf(i);
//            int len = str.length();
//
//            boolean flag = false;
//            for (int j = 0; j < len; j++) {
//                if (arr[str.charAt(j) - '0']) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag)
//                continue;
//            int min = Math.abs(N - i) + len;
//            res = Math.min(res, min);
//        }
//        System.out.println(res);
//    }
public static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if(m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(m-->0)
                broken[Integer.parseInt(st.nextToken())] = true;
        }


        int minCount = Math.abs(n-100);

        for(int i=0;i<1000000;i++) {
            int length = length(i);

            if(length > 0) {
                int sum = Math.abs(n-i);
                minCount = Math.min(minCount,length + sum);
            }
        }

        System.out.println(minCount);
    }

    public static int length(int n) {
        if(n == 0) {
            if(broken[0])
                return 0;
            else
                return 1;
        }

        int length = 0;
        while(n > 0) {
            if(broken[n%10])
                return 0;

            n /= 10;
            length++;
        }

        return length;
    }
}
