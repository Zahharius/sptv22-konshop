
package entity;

import java.io.Serializable;
import java.util.Objects;

public class Customer  implements Serializable{
    private String firstname;
    private String lastname;
    private int money;
    private int rating;

    public Customer() {
    }

    public Customer(String firstname, String lastname, int money, int rating) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.money = money;
        this.rating = rating;
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
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.firstname);
        hash = 61 * hash + Objects.hashCode(this.lastname);
        hash = 61 * hash + this.money;
        hash = 61 * hash + this.rating;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.money != other.money) {
            return false;
        }
        if (this.rating != other.rating) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        return true;
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
   
    

