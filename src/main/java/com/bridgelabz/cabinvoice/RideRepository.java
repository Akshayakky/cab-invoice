package com.bridgelabz.cabinvoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<Integer, ArrayList<Ride>> listOfRides;

    public RideRepository() {
        listOfRides = new HashMap<>();
    }

    public void addRides(int userId, ArrayList<Ride> rides) {
        listOfRides.put(userId, rides);
    }

    public ArrayList<Ride> getRides(int userId) {
        return listOfRides.get(userId);
    }
}