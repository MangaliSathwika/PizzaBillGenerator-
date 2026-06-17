import java.util.Scanner;

public class PizzaBillGenerator {

    // Prices
    static final double VEG_PIZZA_PRICE = 150.00;
    static final double NON_VEG_PIZZA_PRICE = 200.00;
    static final double DELUX_VEG_PIZZA_PRICE = 250.00;
    static final double DELUX_NON_VEG_PIZZA_PRICE = 300.00;

    static final double EXTRA_CHEESE_PRICE = 40.00;
    static final double EXTRA_TOPPINGS_PRICE = 35.00;
    static final double PACKAGING_CHARGES = 25.00;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println("       Welcome to PIZZAMANIA  ");
        System.out.println("============================================");
        System.out.println("Select your Pizza:");
        System.out.println("1. Veg Pizza           - Rs. 150");
        System.out.println("2. Non-Veg Pizza       - Rs. 200");
        System.out.println("3. Delux Veg Pizza     - Rs. 250 (Extra Cheese & Toppings included)");
        System.out.println("4. Delux Non-Veg Pizza - Rs. 300 (Extra Cheese & Toppings included)");
        System.out.println("============================================");
        System.out.print("Enter your choice (1-4): ");

        int pizzaChoice = sc.nextInt();

        double basePrice = 0;
        String pizzaName = "";
        boolean isDelux = false;

        switch (pizzaChoice) {
            case 1:
                basePrice = VEG_PIZZA_PRICE;
                pizzaName = "Veg Pizza";
                break;
            case 2:
                basePrice = NON_VEG_PIZZA_PRICE;
                pizzaName = "Non-Veg Pizza";
                break;
            case 3:
                basePrice = DELUX_VEG_PIZZA_PRICE;
                pizzaName = "Delux Veg Pizza";
                isDelux = true;
                break;
            case 4:
                basePrice = DELUX_NON_VEG_PIZZA_PRICE;
                pizzaName = "Delux Non-Veg Pizza";
                isDelux = true;
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                sc.close();
                return;
        }

        double extraCheeseCharge = 0;
        double extraToppingsCharge = 0;
        boolean extraCheese = false;
        boolean extraToppings = false;

        if (!isDelux) {
            System.out.print("Do you want Extra Cheese? (yes/no): ");
            String cheeseInput = sc.next().trim().toLowerCase();
            if (cheeseInput.equals("yes")) {
                extraCheeseCharge = EXTRA_CHEESE_PRICE;
                extraCheese = true;
            }

            System.out.print("Do you want Extra Toppings? (yes/no): ");
            String toppingsInput = sc.next().trim().toLowerCase();
            if (toppingsInput.equals("yes")) {
                extraToppingsCharge = EXTRA_TOPPINGS_PRICE;
                extraToppings = true;
            }
        } else {
            System.out.println("(Delux Pizza already includes Extra Cheese & Extra Toppings!)");
            extraCheese = true;
            extraToppings = true;
        }

        System.out.print("Do you want Take Away? (yes/no): ");
        String takeAwayInput = sc.next().trim().toLowerCase();
        double packagingCharge = 0;
        boolean takeAway = false;
        if (takeAwayInput.equals("yes")) {
            packagingCharge = PACKAGING_CHARGES;
            takeAway = true;
        }

        double totalBill = basePrice + extraCheeseCharge + extraToppingsCharge + packagingCharge;

        System.out.println("\n============================================");
        System.out.println("             PIZZAMANIA - BILL              ");
        System.out.println("============================================");
        System.out.printf("%-30s Rs. %.2f%n", pizzaName + ":", basePrice);

        if (extraCheese && !isDelux) {
            System.out.printf("%-30s Rs. %.2f%n", "Extra Cheese:", extraCheeseCharge);
        } else if (isDelux) {
            System.out.printf("%-30s %s%n", "Extra Cheese:", "Included");
        }

        if (extraToppings && !isDelux) {
            System.out.printf("%-30s Rs. %.2f%n", "Extra Toppings:", extraToppingsCharge);
        } else if (isDelux) {
            System.out.printf("%-30s %s%n", "Extra Toppings:", "Included");
        }

        if (takeAway) {
            System.out.printf("%-30s Rs. %.2f%n", "Packaging Charges:", packagingCharge);
        }

        System.out.println("--------------------------------------------");
        System.out.printf("%-30s Rs. %.2f%n", "TOTAL BILL:", totalBill);
        System.out.println("============================================");
        System.out.println("    Thank you for choosing PIZZAMANIA!      ");
        System.out.println("============================================");

        sc.close();
    }
}