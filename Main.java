import java.util.ArrayList;
import java.util.List;

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