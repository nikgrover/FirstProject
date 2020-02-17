package com.example.firstproject.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormulaTest {
    private Formula formula = new Formula(25000,2);
    private double Tax = 5000;
    private double total = 4500;


    @Test
    public void setTaxes() throws Exception
    {
        assertArrayEquals(Tax,formula.getTaxes());
    }

    private void assertArrayEquals(double tax, double taxes) {
    }

    @Test
    public void setTotal() throws Exception
    {
        assertArrayEquals(total,formula.getTotal());
    }
}