package com.tw.vapasi;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ValetTest {

    @Test
    void expectValetToParkACar() throws UnableToParkException {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        Valet valet = new Valet(parkingLots);

        boolean status = valet.park(new Vehicle(){});

        assertTrue(status);
    }
}