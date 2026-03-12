import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    // CREATE
    public void addProduct(Product product) throws InvalidProductException {
        boolean exists = products.stream()
                .anyMatch(p -> p.getId() == product.getId());

        if (exists) {
            throw new InvalidProductException("Product already exists");
        }

        products.add(product);
    }

    // READ
    public void displayProducts() {
        System.out.printf("%-5s %-10s %-10s %-10s %-10s%n",
                "ID", "Name", "Price", "Quantity", "Category");
        products.forEach(p ->
                System.out.printf("%-5d %-10s %-10.2f %-10d %-10s%n",
                        p.getId(),
                        p.getName(),
                        p.getPrice(),
                        p.getQuantity(),
                        p.getCategory())
        );
    }

    // UPDATE
    public void updateQuantity(int id, int quantity) throws InvalidProductException {
        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new InvalidProductException("Product not found"));

        product.setQuantity(quantity);
    }

    // DELETE
    public void deleteOutOfStock() {
        products.removeIf(p -> p.getQuantity() == 0);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> findProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
}