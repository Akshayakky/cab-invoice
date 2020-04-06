package com.bridgelabz.cabinvoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<Integer, ArrayList<Ride>> listOfRides;

    public RideRepository() {
        listOfRides = new HashMap<>();
    }

    public void addRides(int userId, ArrayList<Ride> rides) throws RideRepositoryException{
        if(rides.size() == 0)
            throw new RideRepositoryException(RideRepositoryException.ExceptionType.NULL_LIST, "Rides Empty");
        listOfRides.put(userId, rides);
    }

    public ArrayList<Ride> getRides(int userId) throws RideRepositoryException{
        ArrayList<Ride> listOfRides = this.listOfRides.get(userId);
        if(listOfRides == null)
            throw new RideRepositoryException(RideRepositoryException.ExceptionType.NO_VALUE_FOUND, "No Rides Found");
        return listOfRides;
    }
}