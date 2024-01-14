
package zaharius.simanius;

import entity.Customer;
import entity.Product;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import manager.CustomerManager;
import manager.ProductManager;
import tools.InputProtection;
import manager.SaveManager;
import java.util.List;



public class App {
    private List<Product> products;
    private List<Customer> customers;
    public int history[];
    
    private final ProductManager productManager;
    private final CustomerManager customerManager;
    private SaveManager saveManager;
    
public App(){
    this.saveManager = new SaveManager();
    this.products = saveManager.loadProd();
    this.customers = saveManager.loadCust();
    productManager = new ProductManager();
    customerManager = new CustomerManager();
    this.history = new int[0];
}
    
    private boolean repeat;
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
        System.out.println("8.Рейтинг товаров");
        System.out.println("9.Рейтинг покупателей");
        System.out.println("10.Редактирование товаров");
        System.out.println("11.Редактирование покупателей");
        System.out.println("Выберите номер задачи: ");  
        int task = InputProtection.intInput(0,11); 
        System.out.printf("Вы выбрали функцию %d, чтобы выйти нажмите \"0\", чтобы продолжить нажмите \"1\": ",task);
        int toCont = InputProtection.intInput(0,1);
        if(toCont ==0 )continue;
        switch (task) {
            case 0:
                repeat = false;
                break;
            case 1:
                System.out.println("1.Добавить Товар");
                this.products.add(productManager.createProduct());
                SaveManager.saveProd(this.products);
                break;
            case 2:
                System.out.println("2.Список товаров");
                productManager.showprod(products);
                break;
            case 3:
                System.out.println("3.Добавить покупателя");
                this.customers.add(customerManager.createCustomer());
                SaveManager.saveCust(this.customers);
                break;
            case 4:
                System.out.println("4.Список покупателей"); 
                CustomerManager.custlist(this.customers);
                break;
            case 5:
                System.out.println("5.ПОКУПАЮ");
                System.out.println("---ТОВАРЫ---");
                for (int i = 0; i < products.size(); i++) {
                    System.out.printf("%s. %s%nстоит %s денег%n",
                            i+1,
                            products.get(i).getName(),
                            products.get(i).getPrice()
                    );
                }
                System.out.println("---ПОКУПАТЕЛИ---");
                for (int i = 0; i < customers.size(); i++) {
                    System.out.printf("%s. Имя = %s%nФамилия = %s%nДЕНЬГИ = %s%n",
                            i+1,
                            customers.get(i).getFirstname(),
                            customers.get(i).getLastname(),
                            customers.get(i).getMoney()
                    );
                }
                        System.out.println("Выберите покупателя: ");
                    int scan1 = scanner.nextInt();
                        System.out.println("Выберите товар: ");
                    int scan2 = scanner.nextInt();
                    int pokup = customers.get(scan1-1).getMoney() - products.get(scan2-1).getPrice();
                    customers.get(scan2-1).setMoney(pokup);
                    int rat = 1;
                    int rati = customers.get(scan1-1).getRating() + rat;
                        customers.get(scan1-1).setRating(rati);
                    int ratic = products.get(scan2-1).getRating() + rat;
                        products.get(scan2-1).setRating(rati);
                    this.history = Arrays.copyOf(this.history, this.history.length+1);
                    this.history[this.history.length-1] = products.get(scan2-1).getPrice();
                    SaveManager.saveCust(this.customers);
                    SaveManager.saveProd(this.products);
                break;
            case 6:
                System.out.println("6.Сколько денег заработано");
                int  sum = IntStream.of(history).sum();
                System.out.println("Мы заработали = "+ sum+" ДЕНЕГ");
                break;
            case 7:
                System.out.println("7.Дать покупателю ЕЩЁ ДЕНЕГ");
                for (int i = 0; i < customers.size(); i++) {
                    System.out.printf("%s. Имя = %s%nФамилия = %s%nДЕНЬГИ = %s%n",
                            i+1,
                            customers.get(i).getFirstname(),
                            customers.get(i).getLastname(),
                            customers.get(i).getMoney()
                    );
                System.out.println("Выберите покупателя: ");
                int num1 = scanner.nextInt();
                System.out.println("Введите деньги");
                int num2 = scanner.nextInt();
                int moneyy = customers.get(num1-1).getMoney() + num2;
                        customers.get(num1-1).setMoney(moneyy);
                        SaveManager.saveCust(this.customers);
            }
                break;
            case 8:
                System.out.println("8.Рейтинг товаров");;
                for (int i = 0; i < products.size(); i++) {
                    System.out.printf("%s. %s%nкупили %s раз(а)%n",
                            i+1,
                            products.get(i).getName(),
                            products.get(i).getRating()
                    );
                }
                break;
            case 9:
                System.out.println("9.Рейтинг покупателей");
                for (int i = 0; i < products.size(); i++) {
                    System.out.printf("%s. %s %s%nпокупал здесь %s раз(а)%n",
                                    i+1,
                        customers.get(i).getFirstname(),
                        customers.get(i).getLastname(),
                        customers.get(i).getRating()
                    );
                }
                break;
            case 10:
                System.out.println("10. Редактирование товаров"); 
                productManager.changeprod(products);
                SaveManager.saveProd(this.products);
            break;
            case 11:
                System.out.println("11.Редактирование покупателей");
                CustomerManager.changecast(customers);
                SaveManager.saveCust(this.customers);
                break;
            default:
                System.out.println("леее ты не то нажал");
        }
        }while(repeat);
        System.out.println("ну давай пока");
    }
}
