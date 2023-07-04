package src.week_05;

import java.io.*;
import java.util.*;

/**
 * 백준 1744번 수 묶기
 */
public class Pro1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> pArr = new ArrayList<>();
        ArrayList<Integer> mArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp > 0)
                pArr.add(tmp);
            else
                mArr.add(tmp);
        }
        Collections.sort(pArr, Collections.reverseOrder());
        Collections.sort(mArr);
        int res = 0;
        for (int i = 0; i < pArr.size(); i++) {
            if (i + 1 == pArr.size() || pArr.get(i) == 1 || pArr.get(i + 1) == 1)
                res += pArr.get(i);
            else {
                res += pArr.get(i) * pArr.get(i + 1);
                i++;
            }
        }
        for (int i = 0; i < mArr.size(); i++) {
            if (i + 1 == mArr.size())
                res += mArr.get(i);
            else {
                res += mArr.get(i) * mArr.get(i + 1);
                i++;
            }
        }
        System.out.println(res);
    }
}
