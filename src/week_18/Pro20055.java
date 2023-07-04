package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 20055 - 컨베이어 벨트 위의 로봇
 */
public class Pro20055 {
    static int N, K;
    static ArrayList<Elem> arr = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            arr.add(new Elem(Integer.parseInt(st.nextToken()), false));
        }
        pro();
    }

    private static void pro() {
        int cnt = 0;

        while (K != 0) {
            cnt++;
            // 컨베이어 벨트 이동
            Elem e = arr.remove(arr.size() - 1);
            arr.add(0, e);
            arr.set(N - 1, new Elem(arr.get(N - 1).durability, false));

            for (int i = N - 2; i >= 1; i--) {
                if (arr.get(i).status && !arr.get(i + 1).status && arr.get(i + 1).durability >= 1) {
                    arr.set(i, new Elem(arr.get(i).durability, false));
                    arr.set(i + 1, new Elem(arr.get(i + 1).durability - 1, true));
                    if (arr.get(i + 1).durability == 0)
                        K--;
                }
            }

            // 0번 인덱스에 로봇 내림
            if (arr.get(0).durability > 0) {
                arr.set(0, new Elem(arr.get(0).durability - 1, true));
                if (arr.get(0).durability == 0)
                    K--;
            } else {
                arr.set(0, new Elem(arr.get(0).durability, false));
            }
//            System.out.print(cnt + " : " );
//            for (int i = 0; i < N * 2; i++) {
//                System.out.print(arr.get(i).durability + " ");
//            }
//            System.out.println();
        }
        System.out.println(cnt);
    }

    private static class Elem {
        int durability;
        boolean status;

        public Elem(int durability, boolean status) {
            this.durability = durability;
            this.status = status;
        }
    }
}

