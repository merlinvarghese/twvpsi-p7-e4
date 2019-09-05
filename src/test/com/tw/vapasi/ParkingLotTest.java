package com.tw.vapasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingLotTest {

    @Test
    void expectToParkACarSuccessfully() {
        ParkingLot parkingLot = new ParkingLot(10);
        Vehicle vehicle = getVehicle();
        try {
            parkingLot.park(vehicle);
        } catch (Exception e) {
            Assertions.fail("Fail path");
        }
    }

    @Test
    void unableToParkACar() {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle vehicle1 = getVehicle();
        Vehicle vehicle2 = getVehicle();
        try {
            parkingLot.park(vehicle1);
            parkingLot.park(vehicle2);
            Assertions.fail("Fail path");
        } catch (Exception e) {
            //pass flow
        }
    }

    @Test
    void expectToUnparkAVehicleSuccessfully() {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle vehicle1 = getVehicle();
        try {
            parkingLot.park(vehicle1);
            parkingLot.unPark(vehicle1);
        } catch (Exception e) {
            Assertions.fail("Fail path");
        }
    }

    @Test
    void expectToUnparkAVehicleNotParked() {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle vehicle1 = getVehicle();
        Vehicle vehicle2 = getVehicle();
        try {
            parkingLot.park(vehicle1);
            parkingLot.unPark(vehicle2);
            Assertions.fail("Fail path");
        } catch (Exception e) {
            //pass flow
        }
    }

    private Vehicle getVehicle() {
        return new Vehicle() {
        };
    }


}
