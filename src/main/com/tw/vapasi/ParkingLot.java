package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

//Understands spaces available to halt a vehicle
public class ParkingLot {
    private List<Vehicle> parkedVehicles;
    private Integer maxCapacity;
    private STATUS status;
    private ParkingLotOwner owner;

    enum STATUS {
        AVAILABLE,
        FULL
    }

    public ParkingLot(int capacity) {
        this.parkedVehicles = new ArrayList<>();
        this.maxCapacity = capacity;
        this.status = STATUS.AVAILABLE;
    }

    public ParkingLot(int capacity, ParkingLotOwner parkingLotOwner) {
        this.parkedVehicles = new ArrayList<>();
        this.maxCapacity = capacity;
        this.status = STATUS.AVAILABLE;
        this.owner = parkingLotOwner;
    }

    void park(Vehicle vehicle) throws UnableToParkException {
        if (status.equals(STATUS.FULL)) {
            throw new UnableToParkException();
        }
        parkedVehicles.add(vehicle);
        if (parkedVehicles.size() == maxCapacity) {
            status = STATUS.FULL;
            notifyOwner();
        }
    }

    void unPark(Vehicle vehicle) throws UnableToUnparkException {
        if (!parkedVehicles.contains(vehicle)) {
            throw new UnableToUnparkException();
        }
        parkedVehicles.remove(vehicle);
        if (parkedVehicles.size() == maxCapacity - 1 && status.equals(STATUS.FULL)) {
            status = STATUS.AVAILABLE;
            notifyOwner();
        }
    }

    private void notifyOwner() {
        if (this.owner == null) {
            return;
        }
        if (status.equals(STATUS.FULL)) {
            this.owner.notifyParkingIsFull();
            return;
        }
        this.owner.notifyParkingIsAvailable();
    }

    boolean isVehicleParked(Vehicle vehicle) {
        return parkedVehicles.contains(vehicle);
    }
}
