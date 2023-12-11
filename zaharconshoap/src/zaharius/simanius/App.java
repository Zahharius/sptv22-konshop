
package zaharius.simanius;

import entity.Customer;
import entity.History;
import entity.Product;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import manager.CustomerManager;
import manager.HistoryManager;
import manager.ProductManager;
import tools.InputProtection;


public class App {
    private Product[] products;
    private Customer[] customers;
    int history[];
    
   //private final ProductManager productManager;
    
public App(){
    //productManager = new ProductManager();
    this.products = new Product[0];
    this.customers = new Customer[0];
    this.history = new int[0];
}
    
    private boolean repeat;
    private List<History> histories;
    public void run(){
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
   
    do{
        System.out.println("Канселярский уголок Захара");
        System.out.println("0.Выход из программы");
        System.out.println("1.Добавить Товар");
        System.out.println("2.Список товаров");
        System.out.println("3.Добавить покупателя");
        System.out.println("4.Список покупателей");
        System.out.println("5.ПОКУПАЮ");
        System.out.println("6.Сколько денег заработано");
        System.out.println("7.Дать покупателю ЕЩЁ ДЕНЕГ");
        System.out.println("Выберите номер задачи: ");  
        int task = InputProtection.intInput(0,8); 
         System.out.println("_____________________________");
        switch(task){
            case 0:
                repeat = false;
                break;
            case 1:
                System.out.println("1.Добавить Товар");
                ProductManager productManager = new ProductManager();
                this.products = Arrays.copyOf(this.products, this.products.length+1);
                this.products[this.products.length-1] = productManager.createProduct();
                break;
            case 2:
                System.out.println("2.Список товаров");
                for (int i = 0; i<products.length;i++){
                    Product producti = products[i];
                    System.out.printf(i+1+". "+"%s%n",producti.getName());
                    System.out.printf("%s%n", "стоит "+producti.getPrice()+" ДЕНЕГ");
                }
                break;
            case 3:
                System.out.println("3.Добавить покупателя");
                CustomerManager customerManager = new CustomerManager();
                this.customers = Arrays.copyOf(this.customers, this.customers.length+1);
                this.customers[this.customers.length-1] = customerManager.createCustomer();
                break;
            case 4:
                System.out.println("4.Список покупателей"); 
                for (int i = 0; i<customers.length;i++){
                    Customer customer = customers[i];
                    System.out.printf(i+1+". "+"Имя = %s%n", customer.getFirstname());
                    System.out.printf("Фамилия = %s%n", customer.getLastname());
                    System.out.printf("ДЕНЬГИ = %s%n", customer.getMoney());
                }
                break;
            case 5:
                System.out.println("5.ПОКУПАЮ");
                for (int i = 0; i<products.length;i++){
                    Product producti = products[i];
                    System.out.printf(i+1+". "+"Товар   = %s%n", producti.getName());
                    System.out.printf("Цена = %s%n", producti.getPrice());
                }
                for (int i = 0; i<customers.length;i++){
                    Customer customer = customers[i];
                    System.out.printf(i+1+". "+"Имя = %s%n", customer.getFirstname());
                    System.out.printf("Фамилия = %s%n", customer.getLastname());
                    System.out.printf("ДЕНЬГИ = %s%n", customer.getMoney());
                        System.out.println("Выберите покупателя: ");
                    int scan1 = scanner.nextInt();
                        System.out.println("Выберите товар: ");
                    int scan2 = scanner.nextInt();
                    int pokup = customers[scan1-1].getMoney() - products[scan2-1].getPrice();
                    customers[scan2-1].setMoney(pokup);
                    this.history = Arrays.copyOf(this.history, this.history.length+1);
                    this.history[this.history.length-1] = products[scan2-1].getPrice();
                }
                break;
            case 6:
                System.out.println("6.Сколько денег заработано");
                int  sum = IntStream.of(history).sum();
                System.out.println("Мы заработали = "+ sum+" ДЕНЕГ");
                
                break;
            case 7:
                System.out.println("7.Дать покупателю ЕЩЁ ДЕНЕГ");
                 for (int i = 0; i<customers.length;i++){
                    Customer customer = customers[i];
                    System.out.printf(i+1+". "+"Имя = %s%n", customer.getFirstname());
                    System.out.printf("Фамилия = %s%n", customer.getLastname());
                    System.out.printf("ДЕНЬГИ = %s%n", customer.getMoney());
                 }
                System.out.println("Выберите покупателя: ");
                int num1 = scanner.nextInt();
                System.out.println("Введите деньги");
                int num2 = scanner.nextInt();
                int moneyy = customers[num1-1].getMoney() + num2;
                        customers[num1-1].setMoney(moneyy);
                break;
                default:
                System.out.println("леее ты не то нажал");
        }
        }while(repeat);
        System.out.println("ну давай пока");
    
    } 
}
