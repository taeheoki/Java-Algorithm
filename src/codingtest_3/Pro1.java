package src.codingtest_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pro1 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution("pizza")));
        System.out.println(Arrays.toString(solution("ab")));
        System.out.println(Arrays.toString(solution("mississippi")));
        System.out.println(Arrays.toString(solution("aabcddddefggg")));
        System.out.println(Arrays.toString(solution("abyyy")));
        System.out.println(Arrays.toString(solution("kkkkkkk")));
        System.out.println(Arrays.toString(solution("aabb")));
        System.out.println(Arrays.toString(solution("abcdefghijklmnopqrstuvwxyz")));
    }

    public static String[] solution(String s) {
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.length() > 1 && s.charAt(i) == s.charAt(i + 1)) {
                arr.add("");
                continue;
            } else if (i == s.length() - 1 && s.length() > 1 && s.charAt(i - 1) == s.charAt(i)) {
                arr.add("");
                continue;
            }
            if (i + 1 < s.length() && s.length() > 1 && s.charAt(i) == s.charAt(i + 1))
                continue;
            if (i != 0 && s.length() > 1 && s.charAt(i - 1) == s.charAt(i))
                continue;
            int start = i;
            int end = i + 1;
            while (i + 1 < s.length() && s.length() > 1 && s.charAt(i) != s.charAt(i + 1)) {
                i++;
                end = i;
                if (i == s.length() - 1)
                    end++;
            }
            arr.add(s.substring(start, end));
        }

        String[] ans = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }


//    public static String[] solution(String s) {
//        ArrayList<String> arr = new ArrayList<>();
//
//        int i = 0;
//        while (i < s.length()) {
//            int start = i;
//            int end = i + 1;
//            if (i == 0 && s.length() > 1 && s.charAt(i) == s.charAt(i + 1)) {
//                i++;
//                arr.add("");
//                continue;
//            }
//            if (i == s.length() - 1 && s.length() > 1 && s.charAt(i - 1) == s.charAt(i)) {
//                i++;
//                arr.add("");
//                continue;
//            }
//            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
//                i++;
//                continue;
//            }
//            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
//                i++;
//                continue;
//            }
//            while (i + 1 < s.length() && s.charAt(i) != s.charAt(i + 1)) {
//                i++;
//                end = i;
//            }
//            arr.add(s.substring(start, end));
//            if (end == start + 1)
//                i++;
//        }
//
//        String[] ans = new String[arr.size()];
//        for (i = 0; i < arr.size(); i++) {
//            ans[i] = arr.get(i);
//        }
//        return ans;
//    }

//    public static String[] solution(String s) {
//        ArrayList<String> arr = new ArrayList<>();
//        rec_func(s, arr);
//        String[] ans = new String[arr.size()];
//        for (int i = 0; i < arr.size(); i++) {
//            ans[i] = arr.get(i);
//        }
//        return ans;
//    }
//
//    private static void rec_func(String s, ArrayList<String> arr) {
//        int i = 0;
//        int start = i;
//        int end = i;
//        boolean flag = false;
//        while (i + 1 < s.length() && s.charAt(i) != s.charAt(i + 1)) {
//            start++;
//            i++;
//        }
//        while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
//            i++;
//            end = i;
//            flag = true;
//        }
//        if (s.length() == 1)
//            arr.add(s);
//        else {
//            if (s.substring(0, start) == "" && !arr.isEmpty() && arr.get(arr.size() - 1) != "")
//                arr.add(s.substring(0, start));
//            else if (s.substring(0, start) != "")
//                arr.add(s.substring(0, start));
//        }
//        if (flag)
//            rec_func(s.substring(end + 1), arr);
//    }
}
