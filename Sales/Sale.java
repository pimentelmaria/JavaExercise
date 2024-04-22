package Sales;

import Users.Customer;
import Users.SingularPerson;
import Users.Company;

public abstract class Sale {
    public String productId;
    public double unitPriceWithoutTax;
    public int quantity;
    public double taxRate;
    public Customer customer;
    public Company seller;
    public SingularPerson buyer;

    public Sale(String productId, double unitPriceWithoutTax, int quantity, double taxRate, Customer customer, Company seller) {
        this.productId = productId;
        this.unitPriceWithoutTax = unitPriceWithoutTax;
        this.quantity = quantity;
        this.taxRate = taxRate;
        this.customer = customer;
        this.seller = seller;
    }
    
    public Sale(String productId, double unitPriceWithoutTax, int quantity, double taxRate, Customer customer, SingularPerson buyer) {
        this.productId = productId;
        this.unitPriceWithoutTax = unitPriceWithoutTax;
        this.quantity = quantity;
        this.taxRate = taxRate;
        this.customer = customer;
        this.buyer = buyer;
    }

    public String getProductId() {
        return productId;
    }

    public double getUnitPriceWithoutTax() {
        return unitPriceWithoutTax;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Company getCompany() {
        return seller;
    }
    
    public SingularPerson getSingularPerson() {
        return buyer;
    }

}
