package manager;

import entity.Product;
import entity.Customer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class SaveManager {
    private final static String PRODUCTS_FILENAME = "products";
    private final static String CUSTOMER_FILENAME = "customers";

    public List<Product> loadProd() {
        List<Product> products = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(PRODUCTS_FILENAME);
            ois = new ObjectInputStream(fis);   
            products = (List<Product>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n",PRODUCTS_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n",PRODUCTS_FILENAME);
        }
        return products;
    }

    public static void saveProd(List<Product> products) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(PRODUCTS_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.flush();
        } catch (FileNotFoundException ex) {
           System.out.printf("File \"%s\" not found!%n",PRODUCTS_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }
    public List<Customer> loadCust() {
        List<Customer> customers = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(CUSTOMER_FILENAME);
            ois = new ObjectInputStream(fis);
            customers = (List<Customer>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n",CUSTOMER_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n",CUSTOMER_FILENAME);
        }
        return customers;
    }

    public static void saveCust(List<Customer> customers) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(CUSTOMER_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
            oos.flush();
        } catch (FileNotFoundException ex) {
           System.out.printf("File \"%s\" not found!%n",PRODUCTS_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }
}