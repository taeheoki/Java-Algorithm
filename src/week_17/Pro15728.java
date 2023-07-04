package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * BOJ 15728 - 에리 - 카드
 */
public class Pro15728 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr1 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr2.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr1);
        Collections.sort(arr2);
        while (K-- > 0) {
            int left = arr2.get(0);
            int right = arr2.get(arr2.size() - 1);
            int tmp1 = left * arr1.get(0);
            int tmp2 = left * arr1.get(arr1.size() - 1);
            int tmp3 = right * arr1.get(0);
            int tmp4 = right * arr1.get(arr1.size() - 1);
            if (tmp1 > tmp2) {
                if (tmp1 > tmp3) {
                    if (tmp1 > tmp4) {
                        arr2.remove(0);
                    } else {
                        arr2.remove(arr2.size() - 1);
                    }
                } else {
                    arr2.remove(arr2.size() - 1);
                }
            } else {
                if (tmp2 > tmp3) {
                    if (tmp2 > tmp4) {
                        arr2.remove(0);
                    } else {
                        arr2.remove(arr2.size() - 1);
                    }
                } else {
                    arr2.remove(arr2.size() - 1);
                }
            }
        }
        int left = arr2.get(0);
        int right = arr2.get(arr2.size() - 1);
        int tmp1 = left * arr1.get(0);
        int tmp2 = left * arr1.get(arr1.size() - 1);
        int tmp3 = right * arr1.get(0);
        int tmp4 = right * arr1.get(arr1.size() - 1);
        int ans = Math.max(tmp1, Math.max(tmp2, Math.max(tmp3, tmp4)));
        System.out.println(ans);
    }
}
