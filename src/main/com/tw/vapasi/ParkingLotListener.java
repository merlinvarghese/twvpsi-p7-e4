package com.tw.vapasi;


//Understands Owner of Parking Lot
interface ParkingLotListener {
    void notifyParkingIsFull();

    void notifyParkingIsAvailable();
}
