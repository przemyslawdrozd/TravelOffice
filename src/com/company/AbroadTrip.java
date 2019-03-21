package com.company;

import java.time.LocalDate;

public class AbroadTrip extends Trip {

    private int insurance;

    public AbroadTrip(LocalDate start, LocalDate end, String destination, int insurance, int price) {
        super(start, end, destination, price);
        this.insurance = insurance;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + insurance;
    }
}
