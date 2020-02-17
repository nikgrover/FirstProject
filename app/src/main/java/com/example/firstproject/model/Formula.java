package com.example.firstproject.model;

public class Formula
{
    //constants
    private static final Integer minCar = 25000;
    private static final Integer minBike = 10000;
    private static final Integer minPlane = 9500000;
    private static final Integer minBoat = 145500;

    private double Uprice;
    private Integer Qty;
    private double taxes;

    public void setUprice(double uprice) {
        Uprice = uprice;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public double getTaxes() {
        return taxes;
    }

    public double getTotal() {
        return total;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double total;



    public Formula(double Uprice , Integer Qty)
    {
        this.Uprice = Uprice;
        this.Qty = Qty;
        this.Tax();
        this.Calculate();

    }

            private void Tax(){
                this.taxes = (double)(Uprice*Qty)*15/100;
                this.setTaxes(taxes);
            }

            private void Calculate(){
                this.total = (double)(Uprice*Qty) + taxes;
                this.setTotal(total);
            }


}