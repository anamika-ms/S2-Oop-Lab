import java.util.Scanner;

class Product {
    String pcode, pname;
    double price;

    Product(String pcode, String pname, double price) {
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
    }

    static Product findLowest(Product[] products) {
        Product lowest = products[0];
        for (Product p : products) {
            if (p.price < lowest.price) {
                lowest = p;
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("Pcode: ");
            String pcode = sc.next();
            System.out.print("Pname: ");
            String pname = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            products[i] = new Product(pcode, pname, price);
        }

        Product lowest = findLowest(products);
        System.out.println("\nProduct with Lowest Price:");
        System.out.println("Pcode: " + lowest.pcode + ", Pname: " + lowest.pname + ", Price: " + lowest.price);

    }
}
