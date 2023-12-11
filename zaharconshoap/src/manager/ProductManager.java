
package manager;

import entity.Product;
import java.util.Scanner;


public class ProductManager {
    private Scanner scanner;
    
    public ProductManager(){
        this.scanner = new Scanner(System.in);
    }
    public Product createProduct(){
        Product product = new Product();
        System.out.println("Введите название товара: ");
        product.setName(scanner.nextLine());
        System.out.println("Введите цену товара: ");
        product.setPrice(scanner.nextInt());
        scanner.nextLine();
        return product;
        
    }
}