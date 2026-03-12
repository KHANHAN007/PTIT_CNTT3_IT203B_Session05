import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager pm = new ProductManager();

        int choice;

        do {
            System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm hết hàng");
            System.out.println("5. Thoát");
            System.out.println("=============================================");
            System.out.print("Lựa chọn của bạn: ");

            choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Quantity: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Category: ");
                        String category = sc.nextLine();

                        Product product = new Product(id, name, price, quantity, category);
                        pm.addProduct(product);

                        System.out.println("Product added!");
                        break;

                    case 2:
                        pm.displayProducts();
                        break;

                    case 3:
                        System.out.print("Enter product ID: ");
                        int updateId = sc.nextInt();

                        Optional<Product> optional = pm.findProductById(updateId);

                        if(optional.isEmpty()){
                            System.out.println("Product not found!");
                            break;
                        }

                        System.out.print("Enter new quantity: ");
                        int newQuantity = sc.nextInt();

                        pm.updateQuantity(updateId, newQuantity);

                        System.out.println("Updated successfully!");
                        break;

                    case 4:
                        pm.deleteOutOfStock();
                        System.out.println("Deleted successfully!");
                        break;

                    case 5:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice.");

                }

            } catch (InvalidProductException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);
    }
}