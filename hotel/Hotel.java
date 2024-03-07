package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        this.rooms = new ArrayList<>();
    }

    // Method to add rooms to the hotel
    public void addRoom(Room room) {
        rooms.add(room);
    }

    
   

    // Method to make a reservation
    public boolean makeReservation(User user, Room room, java.util.Date checkInDate, java.util.Date checkOutDate) {
        if (room.isAvailable()) {
            room.setAvailability(false); // Mark room as unavailable
            return true;
        }
        return false; // Room not available for reservation
    }
    // Method to check availability of rooms for a given date range
    
    public List<Room> checkAvailability(java.util.Date date, java.util.Date date2) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

}
