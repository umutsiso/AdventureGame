package com.siso;

import java.util.HashMap;
import java.util.Map;

public final class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
         // The hashmap that is passed cannot be changed ! because its a different/new Hashmap and cannot be known. Immutable
        if (exits != null){
            this.exits = new HashMap<>(exits) ;
        } else {
            this.exits = new HashMap<>();
        }
        this.exits.put("Q",0);

         //Adding Quit direction because player should have the liberty to quit from any location.
    }

//    public void addExit(String direction, int location){
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        //Creating a new Hashmap that points to same values but not same hashmap, hence limitting users influence on our exits !
        return new HashMap<>(exits);
    }
}
