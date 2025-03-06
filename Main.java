import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class SliceOHavenPizzeria {
    private String storeName;
    private String storeAddress;
    private String storeEmail;
    private String storePhone;
    private List<String> storeMenu;
    private List<String> pizzaIngredients;
    private double pizzaPrice;
    private List<String> sides;
    private List<String> drinks;
    private String orderID;
    private double orderTotal;

    public static final String DEF_ORDER_ID = "DEF-SOH-099";
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public static final double DEF_ORDER_TOTAL = 15.00;

    public SliceOHavenPizzeria() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = new ArrayList<>();
        this.pizzaIngredients.add(DEF_PIZZA_INGREDIENTS);
        this.orderTotal = DEF_ORDER_TOTAL;
        this.storeName = "";
        this.storeAddress = "";
        this.storeEmail = "";
        this.storePhone = "";
        this.storeMenu = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public SliceOHavenPizzeria(String name, String address, String email, String phone, List<String> menu,
                               List<String> ingredients, double price, List<String> sideItems, List<String> drinkItems) {
        this.storeName = name;
        this.storeAddress = address;
        this.storeEmail = email;
        this.storePhone = phone;
        this.storeMenu = menu;
        this.pizzaIngredients = ingredients;
        this.pizzaPrice = price;
        this.sides = sideItems;
        this.drinks = drinkItems;
        this.orderID = "";
        this.orderTotal = 0.0;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<String> getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(List<String> pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    private void printReceipt() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Order Total: " + orderTotal);
    }

    public void showReceipt() {
        printReceipt();
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String[] ingredients = scanner.nextLine().split(" ");
        String ing1 = ingredients[0];
        String ing2 = ingredients[1];
        String ing3 = ingredients[2];

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = scanner.nextLine();

        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.nextLine();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = scanner.nextLine();

        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        String drink = scanner.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.nextLine();

        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }
    }

    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthday (MM/dd/yyyy):");
        String birthdateStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date birthdate = null;
        try {
            birthdate = sdf.parse(birthdateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date today = new Date();
        int age = today.getYear() - birthdate.getYear();
        if (today.getMonth() < birthdate.getMonth() || (today.getMonth() == birthdate.getMonth() && today.getDate() < birthdate.getDate())) {
            age--;
        }

        boolean isBirthday = today.getMonth() == birthdate.getMonth() && today.getDate() == birthdate.getDate();
        if (age < 18 && isBirthday) {
            System.out.println("Congratulations! You pay only half the price for your order");
            this.orderTotal /= 2;
        } else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }
    }

    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number:");
        long cardNumber = scanner.nextLong();
        scanner.nextLine(); 

        System.out.println("Enter the card’s expiry date (MM/yyyy):");
        String expiryDate = scanner.nextLine();

        System.out.println("Enter the card’s cvv number (3 digits):");
        int cvv = scanner.nextInt();

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);
        int cardLength = cardNumberStr.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }

        int firstCardDigit = Integer.parseInt(cardNumberStr.substring(0, 1));
        long blacklistedNumber = 12345678901234L;
        if (cardNumber == blacklistedNumber) {
            System.out.println("Card is blacklisted. Please use another card");
        }

        int lastFourDigits = Integer.parseInt(cardNumberStr.substring(cardNumberStr.length() - 4));

        StringBuilder cardNumberToDisplayBuilder = new StringBuilder();
        cardNumberToDisplayBuilder.append(cardNumberStr.charAt(0));
        for (int i = 1; i < cardNumberStr.length() - 4; i++) {
            cardNumberToDisplayBuilder.append('*');
        }
        cardNumberToDisplayBuilder.append(cardNumberStr.substring(cardNumberStr.length() - 4));
        String cardNumberToDisplay = cardNumberToDisplayBuilder.toString();

        System.out.println("First card digit: " + firstCardDigit);
        System.out.println("Last four digits: " + lastFourDigits);
        System.out.println("Card number to display: " + cardNumberToDisplay);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder specialInfo = new StringBuilder();
        specialInfo.append("Pizza of the day: ").append(pizzaOfTheDay);
        specialInfo.append("\nSide of the day: ").append(sideOfTheDay);
        specialInfo.append("\nSpecial price: ").append(specialPrice);

        System.out.println(specialInfo.toString());
    }
}

public class Main {
    public static void main(String[] args) {

        SliceOHavenPizzeria pizza1 = new SliceOHavenPizzeria();
        System.out.println("Details of pizza1 (using default constructor):");
        pizza1.showReceipt();

        List<String> menu = new ArrayList<>();
        menu.add("Margherita Pizza");
        menu.add("Pepperoni Pizza");

        List<String> ingredients = new ArrayList<>();
        ingredients.add("Tomato");
        ingredients.add("Basil");

        List<String> sideItems = new ArrayList<>();
        sideItems.add("Garlic Bread");

        List<String> drinkItems = new ArrayList<>();
        drinkItems.add("Coke");

        SliceOHavenPizzeria pizza2 = new SliceOHavenPizzeria("Slice o' Heaven", "123 Pizza St", "info@sliceoheaven.com",
                "123 - 456 - 7890", menu, ingredients, 12.99, sideItems, drinkItems);

        pizza2.takeOrder();

        System.out.println("\nDetails of pizza2 (after taking order):");
        pizza2.showReceipt();
    }
}