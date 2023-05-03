package com.example.dormitory_manager.Controller;

public class RoomNotFoundException extends Throwable {
    public RoomNotFoundException(String message) {
        super(message);
    }
    
}
