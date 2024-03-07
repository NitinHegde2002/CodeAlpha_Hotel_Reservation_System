package hotel;

public class Payment {
    // Method to process payment
    public boolean processPayment(User user, double amount) {
        // Simulate payment processing
        // Here you could integrate with a payment gateway or system
        // For simplicity, we'll just print a success message
        System.out.println("Processing payment of $" + amount + " for user: " + user.getName());
        // Simulate payment success (could be replaced with actual payment processing logic)
        return true;
    }
}