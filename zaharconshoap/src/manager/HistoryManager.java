package manager;

import entity.Customer;
import entity.History;
import entity.Product;

import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import tools.InputProtection;


public class HistoryManager {
    private final Scanner scanner;

    public HistoryManager() {
        scanner = new Scanner(System.in);
    }
    
    public History purchase(Product[] products, Customer[] customers){
        System.out.println("Список читателей: ");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(i+1+". "+customers[i].getFirstname()+" "+customers[i].getLastname());
        }
        System.out.print("Выбери читателя: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список книг: ");
        for (int i = 0; i < products.length; i++) {
            System.out.print(i+1+". "+products[i].getName()+". ");
            for (int j = 0; j < products[i].getAuthors().lenght; j++) {
                System.out.printf("%s %s %d", 
                        products[i].getName(),
                        products[i].getName(),
                        products[i].getPrice());

            }
            System.out.println();
        }
        System.out.print("Выбери номер продукта: ");
        int numberBook = scanner.nextInt();scanner.nextLine();
        History history = new History();
        history.setProduct(products[numberBook - 1]);
        history.setCustomer(customers[numberReader-1]);
        history.setPurchase(new GregorianCalendar().getTime());
        return history;
    }
    

    
    
}