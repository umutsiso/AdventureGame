package com.siso;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        locations.put(0, new Location(0, "In front of PC - Sitting", new HashMap<>()));



        Map<String,Integer> tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("N", 5);
        tempExit.put("S", 4);
        tempExit.put("E", 3);
        locations.put(1, new Location(1, "End of a road",tempExit));


        tempExit = new HashMap<>();
        //Exits for Hill
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "on top of a hill", tempExit));

        tempExit = new HashMap<>();
        //Exits for Building
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "inside a building, a well house for small spring", tempExit));

        tempExit = new HashMap<>();
        //Exits for Valley
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        //Exists for Forest
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "In the forest", tempExit));


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
