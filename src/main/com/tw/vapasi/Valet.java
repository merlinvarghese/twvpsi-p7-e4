package com.tw.vapasi;

import java.util.List;

public class Valet {

    private List<ParkingLot> parkingLots;

    Valet(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    boolean park(Vehicle vehicle) throws UnableToParkException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isSlotAvailable()) {
                parkingLot.park(vehicle);
                return true;
            }
        }
        return false;
    }



}
