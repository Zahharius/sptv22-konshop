
package entity;


public class Customer {
    private String firstname;
    private String lastname;
    private int money;
    private int rating;

    public Customer() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    public int getRating() {
        return rating;
    }
    
     public void setRating(int rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "Customer{" + "firstname=" + firstname
                           + ", lastname=" + lastname 
                           + ", money=" + money +
                           ", rating=" + rating +
                                            '}';
    }

}
   
    

