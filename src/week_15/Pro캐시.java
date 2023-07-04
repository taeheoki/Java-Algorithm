package src.week_15;

import java.util.*;

public class Pro캐시 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(5, new String[]{"leo", "leo", "leo"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        int cacheHit = 0;
        int cacheMiss = 0;
        List<String> arr = new ArrayList<>();
        for (String city : cities) {
            if (arr.contains(city.toUpperCase())) {
                cacheHit++;
                arr.remove(city.toUpperCase());
                arr.add(city.toUpperCase());
            } else {
                cacheMiss++;
                if (arr.size() != 0 && arr.size() == cacheSize)
                    arr.remove(0);
                if (arr.size() < cacheSize)
                    arr.add(city.toUpperCase());
            }
        }
        return 1 * cacheHit + 5 * cacheMiss;
    }
}
