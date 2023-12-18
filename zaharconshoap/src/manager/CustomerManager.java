
package manager;

import entity.Customer;

import java.io.Reader;
import java.util.Scanner;


public class CustomerManager {
    private static Scanner scanner;
    
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
    public static void changecast(Customer[] customers) {
        for (int i = 0; i<customers.length;i++){
                    Customer customer = customers[i];
                    System.out.printf(i+1+". "+"Имя = %s%n", customer.getFirstname());
                    System.out.printf("Фамилия = %s%n", customer.getLastname());
                    System.out.printf("ДЕНЬГИ = %s%n", customer.getMoney());
                }
            System.out.print("Выберите номер покупателя: ");
            int numberCustom = scanner.nextInt();scanner.nextLine();
            System.out.println("Имя: "+customers[numberCustom-1].getFirstname());
            System.out.print("Изменить? (y/n): ");
            String letter = scanner.nextLine();
            if(letter.equals("y")){
                System.out.println("Введите новое имя: ");
                customers[numberCustom - 1].setFirstname(scanner.nextLine());
            }
            System.out.println("Фамилия: "+customers[numberCustom-1].getLastname());
            System.out.print("Изменить? (y/n): ");
            letter = scanner.nextLine();
            if(letter.equals("y")){
                System.out.println("Введите фамилию: ");
                customers[numberCustom - 1].setLastname(scanner.nextLine());
            }
    }

}

 
    
