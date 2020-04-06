package com.bridgelabz.cabinvoice;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CabInvoiceTest {
    //  Welcome To Cab Invoice Problem
    @Test
    public void givenDistanceTime_ReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(10, 10);
        double totalFare = invoiceGenerator.getTotalFare();
        Assert.assertEquals(110, totalFare, 0);
    }

    @Test
    public void givenLessDistanceTime_ReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(0.1, 1);
        double totalFare = invoiceGenerator.getTotalFare();
        Assert.assertEquals(5, totalFare, 0);
    }

    @Test
    public void givenDistanceTimeForRides_ReturnInvoiceSummary() {
        ArrayList<Ride> rides = new ArrayList<>(Arrays.asList(new Ride(12, 10)
                , new Ride(6, 12), new Ride(24, 12)));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        InvoiceSummary invoiceSummary = invoiceGenerator.getTotalFare(rides);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(3, 454, 151.33333333333334);
        Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
    }

    @Test
    public void givenDistanceTimeAndUserIdForRides_ReturnInvoiceSummary() {
        ArrayList<Ride> rides = new ArrayList<>(Arrays.asList(new Ride(12, 10)
                , new Ride(6, 12), new Ride(24, 12)));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        int userId = 1;
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceGenerator.getTotalFare(userId);
        InvoiceSummary invoiceSummaryExpected = invoiceGenerator.getTotalFare(rides);
        Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
    }
}
