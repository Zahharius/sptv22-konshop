package manager;

import entity.Customer;
import entity.History;
import entity.Product;

import java.util.GregorianCalendar;
import java.util.Scanner;



public class HistoryManager {
    private final Scanner scanner;

    public HistoryManager() {
        scanner = new Scanner(System.in);
    }
    
    public History purchase(Product[] products, Customer[] customers){
        System.out.println("Список покупателей: ");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(i+1+". "+customers[i].getFirstname()+" "+customers[i].getLastname());
      
        System.out.print("Выбери номер товара: ");
        int numberBook = scanner.nextInt();scanner.nextLine();
        History history = new History();
        history.setProduct(products[numberBook - 1]);
        history.setCustomer(customers[numberCustomer-1]);
        history.setPurchase(new GregorianCalendar().getTime());
        return history;
    }
    

    
    
