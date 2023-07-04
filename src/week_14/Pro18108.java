package src.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 18108 - 1998년생인 내가 태국에서는 2541년생?!
 */
public class Pro18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        System.out.println(year - (2541 - 1998));
    }
}
