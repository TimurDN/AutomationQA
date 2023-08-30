package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleBase implements Train {
    protected static final int PASSENGER_CAPACITY_MIN_VALUE = 30;
    public static final int PASSENGER_CAPACITY_MAX_VALUE = 150;
    private int carts;

    public static final int CARTS_COUNT_MIN_VALUE = 1;
    public static final int CARTS_COUNT_MAX_VALUE = 15;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, VehicleType.LAND, pricePerKilometer);
        //validatePassengerCapacity(passengerCapacity); deleted after calling method from ValidationHelper.
        ValidationHelper.validateValueInRange(passengerCapacity,
                PASSENGER_CAPACITY_MIN_VALUE,
                PASSENGER_CAPACITY_MAX_VALUE,
                "A train cannot have less than 30 passengers or more than 150 passengers.");

        ValidationHelper.validateValueInRange(carts,
                CARTS_COUNT_MIN_VALUE,
                CARTS_COUNT_MAX_VALUE,
                "A train cannot have less than 1 cart " +
                        "or more than 15 carts!");

        //validatePricePerKilometer(pricePerKilometer); // already called in super not necessary
        //validateCarts(carts); // deleted after calling ValidationHelper method and after implementing it in the constructor.

        this.carts = carts;

    }
//priceperKM missing how to add it from abstract class

    @Override
    public int getCarts() {
        return carts;
    }

    @Override
    public String getAsString() {
        return String.format("Train ----%n" +
                        "Passenger capacity: %d%n" +
                        "Price per kilometer: %.2f%n" +
                        "Vehicle type: %s%n" +
                        "Carts amount: %d",
                getPassengerCapacity(), getPricePerKilometer(), getType(), getCarts());
    }

    // Will be deleted after calling method from Validation Helper.
    private void validateCarts(int carts) {
        if (carts < CARTS_COUNT_MIN_VALUE || carts > CARTS_COUNT_MAX_VALUE) {
            throw new IllegalArgumentException("A train cannot have less than 1 cart or more than 15 carts!");
        }
    }

    // Will be deleted after calling method from Validation Helper.
    public void validatePassengerCapacity(int passengerCapacity){
        if (passengerCapacity < PASSENGER_CAPACITY_MIN_VALUE || passengerCapacity > PASSENGER_CAPACITY_MAX_VALUE) {
            throw new IllegalArgumentException("A train with less than 30 passengers or more " +
                    "than 150 passengers cannot exist!");
        }
    }

}
