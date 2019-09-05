package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

//Understands spaces available to halt a vehicle
public class ParkingLot {
    private List<Vehicle> parkedVehicles;
    private Integer maxCapacity;

    public ParkingLot( int capacity ) {
        parkedVehicles = new ArrayList<>();
        maxCapacity = capacity;
    }

    void park( Vehicle vehicle ) throws UnableToParkException {
        if( parkedVehicles.size() == maxCapacity )
        {
            throw new UnableToParkException();
        }
        parkedVehicles.add(vehicle);
    }

    void unPark( Vehicle vehicle ) throws UnableToUnparkException {
        if( !parkedVehicles.contains(vehicle) )
        {
            throw new UnableToUnparkException();
        }
        parkedVehicles.remove(vehicle);
    }
}
