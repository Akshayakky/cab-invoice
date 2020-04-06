package com.bridgelabz.cabinvoice;

import java.util.ArrayList;

public class InvoiceGenerator {
    private int COST_PER_KILOMETER = 10;
    private int COST_PER_MINUTE = 1;
    private int MINIMUM_COST = 5;
    private double distance;
    private double time;
    private double totalFare;
    private double averageFare;
    RideRepository rideRepository;

    public InvoiceGenerator(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public InvoiceGenerator() {
        rideRepository = new RideRepository();
    }

    public double getTotalFare() {
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return (totalFare > MINIMUM_COST) ? totalFare : MINIMUM_COST;
    }

    public InvoiceSummary getTotalFare(ArrayList<Ride> rides) {
        totalFare = 0;
        for (Ride ride :
                rides) {
            this.distance = ride.distance;
            this.time = ride.time;
            this.totalFare += getTotalFare();
        }
        this.averageFare = this.totalFare / rides.size();
        return new InvoiceSummary(rides.size(), this.totalFare, this.averageFare);
    }

    public InvoiceSummary getTotalFare(int userId) {
        return this.getTotalFare(rideRepository.getRides(userId));
    }

    public void addRides(int userId, ArrayList<Ride> rides) {
        rideRepository.addRides(userId, rides);
    }
}