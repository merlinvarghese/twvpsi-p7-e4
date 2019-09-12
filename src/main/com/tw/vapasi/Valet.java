package com.tw.vapasi;

import java.util.HashMap;
import java.util.List;

public class Valet {

    private List<ParkingLot> parkingLots;

    private List<ParkingLotListener> listeners;

    Valet(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    boolean park(Vehicle vehicle) throws UnableToParkException {
       /* for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isSlotAvailable()) {
                parkingLot.park(vehicle);
                return true;
            }
        }
        return false;
        */


    }





}
