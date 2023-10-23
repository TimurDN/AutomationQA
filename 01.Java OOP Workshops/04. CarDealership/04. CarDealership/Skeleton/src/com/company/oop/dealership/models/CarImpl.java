package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Car;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class CarImpl extends VehicleBase implements Car {


    public static final int CAR_SEATS_MIN = 1;
    public static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!",
            CAR_SEATS_MIN,
            CAR_SEATS_MAX);
    private int seats;


    public CarImpl(String make, String model, double price, int seats) {
        super(make, model, price, 4);
        setSeats(seats);
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }

    void validateSeats(int seats) {  //setter içinde yapılması ile ne farkı var
        ValidationHelpers.validateIntRange(
                seats,
                CAR_SEATS_MIN,
                CAR_SEATS_MAX,
                CAR_SEATS_ERR);
    }

    private void setSeats(int seats) {
        validateSeats(seats);
        this.seats = seats;
    }


    @Override
    public String toString() {
        return String.format("%s" +
                "Seats: %d", super.toString(), getSeats());
    }

    //TODO
}
