package src.week_15;

import java.util.ArrayList;

/**
 * 프로그래머스 - 뉴스 클러스터링
 */
public class Pro뉴스클러스터링 {
    public static void main(String[] args) {
//        System.out.println(solution("FRANCE", "french"));
//        System.out.println(solution("handshake", "shake hands"));
//        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
//        System.out.println(solution("abab", "baba"));
    }

    public static int solution(String str1, String str2) {
        String upStr1 = str1.toUpperCase();
        String upStr2 = str2.toUpperCase();

        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        for (int i = 1; i < upStr1.length(); i++) {
            if (isAlpha(upStr1.charAt(i - 1)) && isAlpha(upStr1.charAt(i))) {
                arr1.add(upStr1.substring(i - 1, i + 1));
            }
        }
        for (int i = 1; i < upStr2.length(); i++) {
            if (isAlpha(upStr2.charAt(i - 1)) && isAlpha(upStr2.charAt(i))) {
                arr2.add(upStr2.substring(i - 1, i + 1));
            }
        }
        double res = arr1.size() < arr2.size() ? jaCard(arr1, arr2) : jaCard(arr2, arr1);
        return (int) (res * 65536);
    }

    private static double jaCard(ArrayList<String> small, ArrayList<String> big) {
        // 교집합
        ArrayList<String> copy = new ArrayList<>(big);
        double inter = 0;
        for (int i = 0; i < small.size(); i++) {
            if (copy.contains(small.get(i))) {
                inter++;
                copy.remove(small.get(i));
            }
        }
        // 합집합
        double union = big.size();
        copy = new ArrayList<>(big);
        for (int i = 0; i < small.size(); i++) {
            if (!copy.contains(small.get(i))) {
                union++;
            } else {
                copy.remove(small.get(i));
            }
        }
        if (inter == 0 && union == 0)
            return 1;
        return inter / union;
    }

    private static boolean isAlpha(char cmp) {
        if (cmp >= 'A' && cmp <= 'Z')
            return true;
        return false;
    }
}
