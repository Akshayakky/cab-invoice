package com.bridgelabz.cabinvoice;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {
    //  Welcome To Cab Invoice Problem
    @Test
    public void givenDistanceTime_ReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(10, 10);
        double totalFare = invoiceGenerator.getTotalFare();
        Assert.assertEquals(110, totalFare, 0);
    }
}
