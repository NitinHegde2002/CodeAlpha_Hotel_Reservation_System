import java.util.Date;
import java.util.List;
import java.util.Scanner;

import hotel.Hotel;
import hotel.Payment;
import hotel.Room;
import hotel.User;


public class task4 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        // Add some rooms to the hotel
        Room room1 = new Room(101, "Single", 100.00);
        Room room2 = new Room(102, "Double", 150.00);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        Scanner scanner = new Scanner(System.in);
        User user = createUser(scanner);

        // Display available rooms
        System.out.println("Available rooms:");
        List<Room> availableRooms = hotel.checkAvailability(new Date(), new Date());
        for (Room room : availableRooms) {
            System.out.println(room);
        }

        // Make a reservation
        System.out.println("Enter room number to make a reservation:");
        int roomNumber = scanner.nextInt();
        Room selectedRoom = null;
        for (Room room : availableRooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
                break;
            }
        }
        if (selectedRoom != null) {
            Date checkInDate = new Date(); // For simplicity, using today's date as check-in date
            Date checkOutDate = new Date(); // For simplicity, using today's date as check-out date
            boolean reservationSuccess = hotel.makeReservation(user, selectedRoom, checkInDate, checkOutDate);
            if (reservationSuccess) {
                System.out.println("Reservation successful!");
                // Process payment
                Payment payment = new Payment();
                boolean paymentSuccess = payment.processPayment(user, selectedRoom.getPrice());
                if (paymentSuccess) {
                    System.out.println("Payment successful!");
                } else {
                    System.out.println("Payment failed. Reservation canceled.");
                    // Rollback reservation
                    selectedRoom.setAvailability(true);
                }
            } else {
                System.out.println("Room is not available for reservation.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }
    // Method to create a user
    public static User createUser(Scanner scanner) {
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        System.out.println("Enter user contact information:");
        String contactInfo = scanner.nextLine();
        return new User(name, contactInfo);
    }
}



