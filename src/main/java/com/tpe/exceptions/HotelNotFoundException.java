package com.tpe.exceptions;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }
}
//odev: RoomNotFoundException, ReservationNotFoundException, GuestNotFoundException