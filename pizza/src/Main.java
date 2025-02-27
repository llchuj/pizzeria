import java.util.ArrayList;
import java.util.List;

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

    public void takeOrder(int pizzaCount, List<String> selectedSides, List<String> selectedDrinks) {
        this.orderTotal += (double) pizzaCount * this.pizzaPrice;
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

        List<String> selectedSides = new ArrayList<>();
        selectedSides.add("Garlic Bread");
        List<String> selectedDrinks = new ArrayList<>();
        selectedDrinks.add("Coke");
        pizza2.takeOrder(2, selectedSides, selectedDrinks);

        System.out.println("\nDetails of pizza2 (using parameterized constructor after taking order):");
        pizza2.showReceipt();
    }
}