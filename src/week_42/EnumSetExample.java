package src.week_42;

import java.util.EnumSet;

public class EnumSetExample {
    public static void main(String[] args) {
        // Empty EnumSet
        EnumSet<Day> emptySet = EnumSet.noneOf(Day.class);
        System.out.println("Empty set: " + emptySet);

        // Full EnumSet
        EnumSet<Day> week = EnumSet.allOf(Day.class);
        System.out.println("Full set: " + week);
    }
}
