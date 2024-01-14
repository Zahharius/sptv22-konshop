
package manager;

import entity.Product;

import java.util.List;
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
    public void changeprod(List<Product> products) {
        for (int i = 0; i<products.size();i++){
            System.out.printf("%s. %s%nстоит %s денег%n",
                    i+1,
                    products.get(i).getName(),
                    products.get(i).getPrice()
            );
        }
        System.out.print("Выберите номер товара: ");
        int numberReader = scanner.nextInt();scanner.nextLine();
        System.out.println("Название: "+products.get(numberReader-1).getName());
        System.out.print("Изменить? (y/n): ");
        String letter = scanner.nextLine();
        if(letter.equals("y")){
            System.out.println("Введите новое название товара: ");
            products.get(numberReader - 1).setName(scanner.nextLine());
        }
        System.out.println("Цена: "+products.get(numberReader-1).getPrice());
        System.out.print("Изменить? (y/n): ");
        letter = scanner.nextLine();
        if(letter.equals("y")){
            System.out.println("Введите новую цену: ");
            products.get(numberReader - 1).setPrice(scanner.nextInt());
        }
       
    }
     public void showprod(List<Product> products) {
        System.out.println("----- Products -----");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%s. %s%nстоит %s денег%n",
                    i+1,
                    products.get(i).getName(),
                    products.get(i).getPrice()
            );
        }
    }
    public void prodrat(Product[] products) {
        for (int i = 0; i<products.length;i++){
            Product producti = products[i];
            System.out.printf(i+1+". "+"%s%n",producti.getName());
            System.out.printf("%s%n", "куплено "+producti.getRating()+" раз(а)");
            
        }
    }

}
