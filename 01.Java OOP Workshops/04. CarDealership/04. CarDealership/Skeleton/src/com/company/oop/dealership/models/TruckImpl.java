package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class TruckImpl extends VehicleBase implements Truck {

    public static final int WEIGHT_CAP_MIN = 1;
    public static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);
    private int weightCapacity;

    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make, model, price, 8);
        setWeightCapacity(String.valueOf(weightCapacity));
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    private void setWeightCapacity(String weightCapacity) {
        validateWeightCapacity(weightCapacity);
        this.weightCapacity = Integer.parseInt(weightCapacity);
    }

    void validateWeightCapacity(String weightCapacity) {
        int capacity = Integer.parseInt(weightCapacity);
        ValidationHelpers.validateIntRange(
                capacity,
                WEIGHT_CAP_MIN,
                WEIGHT_CAP_MAX,
                WEIGHT_CAP_ERR);
    }

    @Override
    public String toString() {
        return String.format("%s" +
                "Weight Capacity: %st", super.toString(), getWeightCapacity());
    }

    //TODO
}
