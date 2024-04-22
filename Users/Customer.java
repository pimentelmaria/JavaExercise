package Users;

import java.util.ArrayList;
import java.util.List;

import Sales.Purchase;
import Sales.Selling;

public abstract class Customer {
    private String name;
    private String email;    
    protected List<Purchase> purchases = new ArrayList<>();
    private List<Selling> sellings = new ArrayList<>();
    private boolean alreadyRecordedPurchase = false;
    private boolean alreadyRecordedSelling = false;

    // Constructor
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter for name (read-only)
    public String getName() {
        return name;
    }

    // Getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Abstract method to get identification number
    public abstract String getIdentificationNumber();

   
    // Getter for the list of purchases
    public List<Purchase> getPurchasesList() {
        return purchases;
    }

    // Getter for the list of sellings
    public List<Selling> getSellingsList() {
        return sellings;
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public void addSelling(Selling selling) {
        sellings.add(selling);
    }
    
    public boolean alreadyRecordedPurchase() {
        return alreadyRecordedPurchase;
    }

    public void setAlreadyRecordedPurchase(boolean recorded) {
        this.alreadyRecordedPurchase = recorded;
    }
    

    public boolean alreadyRecordedSelling() {
        return alreadyRecordedSelling;
    }

    public void setAlreadyRecordedSelling(boolean recorded) {
        this.alreadyRecordedSelling = recorded;
    }

}
