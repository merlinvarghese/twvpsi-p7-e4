package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

//Understands spaces available to halt a vehicle
class ParkingLot {
    private List<Vehicle> parkedVehicles;
    private Integer maxCapacity;
    private List<ParkingLotListener> listeners;

    ParkingLot(int capacity) {
        this.parkedVehicles = new ArrayList<>();
        this.maxCapacity = capacity;
    }

    ParkingLot(int capacity, ParkingLotListener parkingLotListener) {
        this.parkedVehicles = new ArrayList<>();
        this.maxCapacity = capacity;
    }

    void park(Vehicle vehicle) throws UnableToParkException {
        if (parkedVehicles.size() == maxCapacity) {
            throw new UnableToParkException();
        }
        parkedVehicles.add(vehicle);
        if (parkedVehicles.size() == maxCapacity) {
            notifyOwnerParkingIsFull();
        }
    }

    boolean isSlotAvailable() {
        return parkedVehicles.size() < maxCapacity;
    }

    void unPark(Vehicle vehicle) throws UnableToUnparkException {
        if (!parkedVehicles.contains(vehicle)) {
            throw new UnableToUnparkException();
        }
        boolean isParkingFull = false;
        if (parkedVehicles.size() == maxCapacity) {
            isParkingFull = true;
        }
        parkedVehicles.remove(vehicle);
        if (parkedVehicles.size() == maxCapacity - 1 && isParkingFull) {
            notifyOwnerParkingIsAvailable();
        }
    }

    private void notifyOwnerParkingIsAvailable() {
        if (this.listeners != null) {
            this.listeners.notifyParkingIsAvailable();
        }

    }

    private void notifyOwnerParkingIsFull() {
        if (this.listeners != null) {
            listeners;
        }

    }

    boolean isVehicleParked(Vehicle vehicle) {
        return parkedVehicles.contains(vehicle);
    }

    public void register(ParkingLotListener listener){
        listeners.add(listener);
    }

    public void unregister(ParkingLotListener listener){
        listeners.remove(listener);
    }
}
