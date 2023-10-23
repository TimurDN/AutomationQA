package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleBase implements Bus {
    private static final int PASSENGER_CAPACITY_MIN_VALUE = 10;
    private static final int PASSENGER_CAPACITY_MAX_VALUE = 50;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, VehicleType.LAND, pricePerKilometer);
        ValidationHelper.validateValueInRange(passengerCapacity,
                PASSENGER_CAPACITY_MIN_VALUE,
                PASSENGER_CAPACITY_MAX_VALUE,
                "A bus cannot have less than 10 passengers " +
                        "or more than 50 passengers!");
       // validatePassengerCapacity(passengerCapacity);// Bus'un kapasite sınırları Vehicledan farklı
        //olduğundan ayrıca kontrol edilmelidir //ValidationHelperdan aldıktan sonra validatePassCap'ı sildik.

    }
    @Override
    public String getAsString() {
        return String.format("Bus ----%n" +
                        "Passenger capacity: %d%n" +
                        "Price per kilometer: %.2f%n" +
                        "Vehicle type: %s",
                getPassengerCapacity(), getPricePerKilometer(), getType());
    }

    public void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_CAPACITY_MIN_VALUE || passengerCapacity > PASSENGER_CAPACITY_MAX_VALUE) {
            throw new IllegalArgumentException("A bus cannot have less than 10 passengers or more than 50 passengers!");
        }
    }

}