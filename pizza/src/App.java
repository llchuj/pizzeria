import java.util.ArrayList;
import java.util.List;

class SliceOHavenPizzeria {
    // 店铺信息
    private String storeName;
    private String storeAddress;
    private String storeEmail;
    private String storePhone;
    // 菜单相关
    private List<String> storeMenu;
    private List<String> pizzaIngredients;
    private double pizzaPrice;
    private List<String> sides;
    private List<String> drinks;
    // 订单信息
    private int orderID;
    private double orderTotal;

    // 构造函数
    public SliceOHavenPizzeria(String name, String address, String email, String phone,
                               List<String> menu, List<String> ingredients, double price,
                               List<String> sideItems, List<String> drinkItems) {
        this.storeName = name;
        this.storeAddress = address;
        this.storeEmail = email;
        this.storePhone = phone;
        this.storeMenu = menu;
        this.pizzaIngredients = ingredients;
        this.pizzaPrice = price;
        this.sides = sideItems;
        this.drinks = drinkItems;
        this.orderID = 0;
        this.orderTotal = 0;
    }

    // 接收订单方法
    public void takeOrder(int pizzaCount, List<String> selectedSides, List<String> selectedDrinks) {
        this.orderID++;
        this.orderTotal += pizzaCount * this.pizzaPrice;
        for (String side : selectedSides) {
            // 假设配菜价格为 5 美元，可根据实际情况修改
            this.orderTotal += 5;
        }
        for (String drink : selectedDrinks) {
            // 假设饮品价格为 3 美元，可根据实际情况修改
            this.orderTotal += 3;
        }
        System.out.println("订单已接收，订单编号: " + this.orderID);
    }

    // 制作披萨方法
    public void makePizza() {
        System.out.println("正在制作带有 " + String.join(", ", this.pizzaIngredients) + " 配料的披萨...");
        System.out.println("披萨制作完成！");
    }

    // 打印收据方法
    public void printReceipt() {
        System.out.println("================ 收据 ================");
        System.out.println("店铺名称: " + this.storeName);
        System.out.println("店铺地址: " + this.storeAddress);
        System.out.println("店铺电话: " + this.storePhone);
        System.out.println("订单编号: " + this.orderID);
        System.out.println("订单总价: $" + this.orderTotal);
        System.out.println("======================================");
    }

    public static void main(String[] args) {
        // 初始化店铺信息
        List<String> menu = new ArrayList<>();
        menu.add("披萨");
        menu.add("配菜");
        menu.add("饮品");

        List<String> ingredients = new ArrayList<>();
        ingredients.add("芝士");
        ingredients.add("番茄");
        ingredients.add("火腿");

        List<String> sideItems = new ArrayList<>();
        sideItems.add("薯条");
        sideItems.add("鸡翅");

        List<String> drinkItems = new ArrayList<>();
        drinkItems.add("可乐");
        drinkItems.add("雪碧");

        SliceOHavenPizzeria pizzeria = new SliceOHavenPizzeria("Slice - o - Heaven", "123 Pizza St",
                "info@sliceoheaven.com", "123 - 456 - 7890", menu, ingredients, 15.0, sideItems, drinkItems);

        // 模拟接收订单
        List<String> selectedSides = new ArrayList<>();
        selectedSides.add("薯条");
        List<String> selectedDrinks = new ArrayList<>();
        selectedDrinks.add("可乐");
        pizzeria.takeOrder(2, selectedSides, selectedDrinks);

        // 制作披萨
        pizzeria.makePizza();

        // 打印收据
        pizzeria.printReceipt();
    }
}