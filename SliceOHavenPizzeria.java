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
    public static final long BLACKLISTED_NUMBER = 12345678901234L;

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


    public String getOrderID() { return orderID; }
    public void setOrderID(String orderID) { this.orderID = orderID; }


    @Override
    public String toString() {
        return "Order ID: " + orderID +
                "\nPizza Ingredients: " + pizzaIngredients +
                "\nOrder Total: " + orderTotal;
    }

    public void showReceipt() {
        System.out.println(this.toString());
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);

    }

    public void isItYourBirthday() {

    }

    public void makeCardPayment() {

    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
     
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
    }
}