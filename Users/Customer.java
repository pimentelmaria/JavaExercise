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

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getIdentificationNumber();

    public List<Purchase> getPurchasesList() {
        return purchases;
    }

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
