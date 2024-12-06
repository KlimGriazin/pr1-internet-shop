import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;

    public Product(int id, String name, double price, String description, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Товар{" +
                "id=" + id +
                ", назва='" + name + '\'' +
                ", ціна=" + price +
                ", опис='" + description + '\'' +
                ", категорія='" + category.getName() + '\'' +
                '}';
    }
}

class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> searchByName(String name) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                results.add(product);
            }
        }
        return results;
    }

    public List<Product> searchByCategory(String categoryName) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().getName().equalsIgnoreCase(categoryName)) {
                results.add(product);
            }
        }
        return results;
    }
}

class Main {
    public static void main(String[] args) {
        // Створення категорій
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Створення товарів і додавання їх до магазину
        Store store = new Store();
        store.addProduct(new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics));
        store.addProduct(new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном", smartphones));
        store.addProduct(new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nОберіть дію:");
            System.out.println("1 - Пошук товару за назвою");
            System.out.println("2 - Пошук товару за категорією");
            System.out.println("3 - Вихід");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буферу після введення числа

            if (choice == 1) {
                System.out.print("Введіть назву товару для пошуку: ");
                String name = scanner.nextLine();
                List<Product> results = store.searchByName(name);
                if (results.isEmpty()) {
                    System.out.println("Товар з такою назвою не знайдено.");
                } else {
                    System.out.println("Знайдені товари:");
                    for (Product product : results) {
                        System.out.println(product);
                    }
                }

            } else if (choice == 2) {
                System.out.print("Введіть назву категорії для пошуку: ");
                String categoryName = scanner.nextLine();
                List<Product> results = store.searchByCategory(categoryName);
                if (results.isEmpty()) {
                    System.out.println("Товари з такою категорією не знайдено.");
                } else {
                    System.out.println("Знайдені товари:");
                    for (Product product : results) {
                        System.out.println(product);
                    }
                }

            } else if (choice == 3) {
                System.out.println("Вихід з програми.");
                break;

            } else {
                System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}
