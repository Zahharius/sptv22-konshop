
package entity;

import java.util.Date;


public class History {
    private Customer customer;
    private Product product;
    private Date purchase;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getPurchase() {
        return purchase;
    }

    public void setPurchase(Date purchase) {
        this.purchase = purchase;
    }
    
    @Override
    public String toString() {
        return "History{"
                +"Customer=" + customer
                +", Product=" + product
                +", purchase=" + purchase
                +"}";
    }

    public Product getBook() {
        return null;
    }

    public Object getReturnBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
