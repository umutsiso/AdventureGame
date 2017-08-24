package com.siso;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "In front of PC - Sitting"));
        locations.put(1, new Location(1, "End of a road"));
        locations.put(2, new Location(2, "on top of a hill"));
        locations.put(3, new Location(3, "inside a building, a well house for small spring"));
        locations.put(4, new Location(4, "in a valley beside a stream"));
        locations.put(5, new Location(5, "In the forest"));

        //Exists for Road
        locations.get(1).addExit("N", 5);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);

        //Exits for Hill
        locations.get(2).addExit("N", 5);

        //Exits for Building
        locations.get(3).addExit("W", 1);

        //Exits for Valley
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        //Exists for Forest
        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);


        int loc = 1;
        while (true) {

            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = new HashMap<>(locations.get(loc).getExits());

            System.out.print("Available exits are : ");
            for (String s : exits.keySet()){
                System.out.print(s + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1){
                direction = StringTransformer(direction);
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You can not go in that direction");
            }


        }
    }


    public static String StringTransformer(String input){

        String[] s = input.split(" ");
        for (String string : s){
            if (string.toUpperCase().equals("WEST")){
                return "W";
            } else if (string.toUpperCase().equals("EAST")){
                return "E";
            } else if (string.toUpperCase().equals("SOUTH")){
                return "S";
            } else if (string.toUpperCase().equals("NORTH")){
                return "N";
            } else if (string.toUpperCase().equals("QUIT")){
                return "Q";
            }
        }
        return null;



    }
}
