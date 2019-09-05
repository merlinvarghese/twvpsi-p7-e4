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

        Assertions.assertThrows(UnableToParkException.class, () -> parkingLot.park(vehicle1));
        Assertions.assertThrows(UnableToParkException.class, () -> parkingLot.park(vehicle2));
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

        Assertions.assertThrows(UnableToUnparkException.class, () -> parkingLot.unPark(vehicle1));
    }

    @Test
    void expectTrueIfTheVehicleIsParked() throws UnableToParkException {
        ParkingLot parkingLot = new ParkingLot(10);
        Vehicle vehicle = getVehicle();
        parkingLot.park(vehicle);

        parkingLot.isVehicleParked(vehicle);
    }

    private Vehicle getVehicle() {
        return new Vehicle() {
        };
    }
}
