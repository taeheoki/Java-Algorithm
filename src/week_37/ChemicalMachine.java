package src.week_37;

import java.util.ArrayList;

public class ChemicalMachine {

    private ArrayList<String> colors;

    public ChemicalMachine() {
        colors = new ArrayList<>();
    }

    public void add(String potion) {
        colors.add(potion);
    }

    public void applyHeat() {
        int greenCount = 0;
        int yelloCount = 0;
        int orangeCount = 0;
        int brownCount = 0;
        int other = 0;
        for (String color : colors) {
            if (color.equals("GREEN"))
                greenCount++;
            else if (color.equals("YELLOW"))
                yelloCount++;
            else if (color.equals("ORANGE"))
                orangeCount++;
            else if (color.equals("BROWN"))
                brownCount++;
            else
                other++;
        }
        if (colors.size() == 2 && greenCount == 2) {
            colors.remove("GREEN");
            colors.remove("GREEN");
            colors.add("ORANGE");
        } else if (colors.size() == 2 && greenCount == 1 && yelloCount == 1) {
            colors.remove("GREEN");
            colors.remove("YELLOW");
            colors.add("BROWN");
        } else if (colors.size() == 1 && orangeCount == 1) {
            colors.remove("ORANGE");
            colors.add("RED");
            colors.add("RED");
        } else if (colors.size() == 1 && brownCount == 1) {
            colors.remove("BROWN");
            colors.add("MAGENTA");
        } else {
//            colors.clear();
//            colors.add("UNKNOWN");
        }
    }

    public ArrayList<String> emptyMachine() {
        ArrayList<String> result = new ArrayList<>(colors);
        colors.clear();
        return result;
    }

    public static void main(String[] args) {
        ChemicalMachine machine = new ChemicalMachine();

        machine.add("GREEN");
        machine.add("GREEN");
        machine.applyHeat();
        System.out.println(String.join(",", machine.emptyMachine())); // should print BROWN

        machine.add("GREEN");
        machine.add("YELLOW");
        machine.applyHeat();
        System.out.println(String.join(",", machine.emptyMachine())); // should print BROWN

        machine.add("RED");
        machine.add("YELLOW");
        machine.applyHeat();
        System.out.println(String.join(",", machine.emptyMachine())); // should print UNKNOWN
    }
}
