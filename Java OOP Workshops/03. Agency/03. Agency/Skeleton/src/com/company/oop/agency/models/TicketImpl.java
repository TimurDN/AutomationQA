package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.utils.ValidationHelper;

public class TicketImpl implements Ticket {

   private int id;
   private Journey journey;  // class/object data field
   private double administrativeCost;


    public TicketImpl(int id, Journey journey, double administrativeCost) {
//        ValidationHelper.validateValueInRange(administrativeCost,
//                0,
//                Double.MAX_VALUE,
//               deleted "Administrative cost cannot be negative");  Validation helper cannot be used here because expected throw output is different(Invalid User Exception)

        validateIsNUll(journey);
        validateAdminCost(administrativeCost);
        this.id = id;
        this.journey = journey;
        this.administrativeCost = administrativeCost;
    }

    public void validateIsNUll(Journey journey){
        if (journey == null){
            throw new IllegalArgumentException("Journey cannot be null");
        }
    }
    public void validateAdminCost(double administrativeCost){
        if (administrativeCost < 0){
            throw new InvalidUserInputException("Administrative cost cannot be negative.");
        }
    }



    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----%n" +
                        "Destination: %s%n" +
                        "Price: %.2f%n",
                journey.getDestination(),calculatePrice());
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return journey.calculateTravelCosts() * administrativeCost;
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCost;
    }
}
