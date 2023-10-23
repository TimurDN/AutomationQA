package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleBase implements Airplane {
    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, VehicleType.AIR, pricePerKilometer);
        this.hasFreeFood = hasFreeFood;
    }
//price perKM method gerekli mi? - kapasite belirtilmemiş, kapasiteyi VehicleBaseden alıyor mu constantlardan?
    //priceperkm ve passengerCapacity Vehicle kurallarını alıyor.
    @Override
    public String getAsString() {

        return String.format("Airplane ----\n" +
                        "Passenger capacity: %d\n" +
                        "Price per kilometer: %.2f\n" +
                        "Vehicle type: %s\n" +
                        "Has free food: %s\n",
                getPassengerCapacity(), getPricePerKilometer(), getType(), hasFreeFood);
    }
    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }
}