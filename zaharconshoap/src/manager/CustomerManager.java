
package manager;

import entity.Customer;
import java.util.Scanner;


public class CustomerManager {
    private Scanner scanner;
    
    public CustomerManager(){
        this.scanner = new Scanner(System.in);
    }
    public Customer createCustomer(){
        Customer customer = new Customer();
        System.out.println("Введите имя: ");
        customer.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию: ");
        customer.setLastname(scanner.nextLine());
        System.out.println("Введите деньги: ");
        customer.setMoney(scanner.nextInt());
        scanner.nextLine();
        return customer;
    }
}
    
