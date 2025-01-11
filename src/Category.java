import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String name;
    private List<Product> productList;

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
        this.productList.remove(product);
    }
}