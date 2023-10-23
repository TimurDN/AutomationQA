package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public abstract class VehicleBase implements Vehicle {
    protected static final int PASSENGER_CAPACITY_MIN_VALUE = 1;
    protected static final int PASSENGER_CAPACITY_MAX_VALUE = 800;
    protected static final double PRICE_PER_KM_MIN_VALUE = 0.1;
    protected static final double PRICE_PER_KM_MAX_VALUE = 2.5;


    private int id;
    private int passengerCapacity;
    private VehicleType type;
    private double pricePerKilometer;
    public VehicleBase(int id, int passengerCapacity, VehicleType type, double pricePerKilometer) {
//        validatePassengerCapacity(passengerCapacity); deleted after calling method from Validation Helper
//        validatePricePerKilometer(pricePerKilometer); deleted after calling method from Validation Helper
        ValidationHelper.validateValueInRange(passengerCapacity,
                PASSENGER_CAPACITY_MIN_VALUE,
                PASSENGER_CAPACITY_MAX_VALUE,
                "A vehicle with less than 1 passengers or " +
                        "more than 800 passengers cannot exist!");

        ValidationHelper.validateValueInRange(pricePerKilometer,
                PRICE_PER_KM_MIN_VALUE, PRICE_PER_KM_MAX_VALUE,
                "A vehicle with a price per kilometer lower than $0.10 " +
                        "or higher than $2.50 cannot exist!");

        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.type = type;
        this.pricePerKilometer = pricePerKilometer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

//Below method deleted after calling method from Validation Helper's class methods.
    public void validatePassengerCapacity(int passengerCapacity){
        if (passengerCapacity < PASSENGER_CAPACITY_MIN_VALUE || passengerCapacity > PASSENGER_CAPACITY_MAX_VALUE){
            throw new IllegalArgumentException("A vehicle with less than 1 passengers or more " +
                    "than 800 passengers cannot exist!");
        }
    }

    //Below method deleted after calling method from Validation Helper's class methods.
    public void validatePricePerKilometer(double pricePerKilometer){
        if (pricePerKilometer < PRICE_PER_KM_MIN_VALUE || getPricePerKilometer() > PRICE_PER_KM_MAX_VALUE){
            throw new IllegalArgumentException("A vehicle with a price per kilometer lower than " +
                    "$0.10 or higher than $2.50 cannot exist!");



        }
    }
}

