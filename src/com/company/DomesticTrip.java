package com.company;

public class DomesticTrip extends Trip {

    private int ownArrivalDiscount;

    public DomesticTrip(Date start, Date end, String destination, int ownArrivalDiscount, int price) {
        super(start, end, destination, price);
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    public int getOwnArrivalDiscount() {
        return ownArrivalDiscount;
    }

    public void setOwnArrivalDiscount(int ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    @Override
    public int getPrice() {
        return super.getPrice() - ownArrivalDiscount;
    }
}
