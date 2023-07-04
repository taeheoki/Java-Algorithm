
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Stack<Integer> s;
    static FastReader scan = new FastReader();
    static void input() {
        N = scan.nextInt();
        s = new Stack<>();
    }

    static void method() {
        int last = 0; // 몇번 push 되었는가
        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();

            if (last < num) {
                for (; last < num; last++) {
                    s.push(last + 1);
                    sb.append("+\n");
                }
            }

            if (s.peek() != num) {
                System.out.println("NO\n");
                return;
            }

            s.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        method();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
