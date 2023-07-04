package src.week_15;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 프로그래머스 - 파일명 정렬
 * 문제 이해:
 */
public class Pro파일명정렬 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }

    public static String[] solution(String[] files) {
        ArrayList<File> arrFile = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String head = getHead(files[i]);
            int number = getNumber(files[i]);
            arrFile.add(new File(head, number, files[i]));
        }
        Collections.sort(arrFile);
        String[] ans = new String[arrFile.size()];
        for (int i = 0; i < arrFile.size(); i++) {
            ans[i] = arrFile.get(i).fullName;
        }
        return ans;
    }

    private static int getNumber(String file) {
        int i = 0;
        for (; i < file.length(); i++) {
            char tmp = file.charAt(i);
            if (isNumber(tmp))
                break;
        }
        int start = i;
        for (; i < file.length(); i++) {
            char tmp = file.charAt(i);
            if (!isNumber(tmp))
                break;
        }
        return Integer.parseInt(file.substring(start, i));
    }

    private static String getHead(String file) {
        for (int i = 0; i < file.length(); i++) {
            char tmp = file.charAt(i);
            if (isNumber(tmp))
                return file.substring(0, i);
        }
        return file;
    }

    private static boolean isNumber(char tmp) {
        if (tmp >= '0' && tmp <= '9')
            return true;
        return false;
    }

    private static class File implements Comparable<File> {
        String head;
        int number;
        String fullName;

        public File(String head, int number, String fullName) {
            this.head = head;
            this.number = number;
            this.fullName = fullName;
        }

        @Override
        public int compareTo(File o) {
            String cmp1 = this.head.toUpperCase();
            String cmp2 = o.head.toUpperCase();
            if (cmp1.compareTo(cmp2) == 0)
                return this.number - o.number;
            return cmp1.compareTo(cmp2);
        }
    }
}
