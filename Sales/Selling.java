package Sales;

import Users.Customer;
import Users.SingularPerson;

public class Selling extends Sale {

    public Selling(String productId, double unitPriceWithoutTax, int quantity, double taxRate, Customer customer, SingularPerson buyer) {
        super(productId, unitPriceWithoutTax, quantity, taxRate, customer, buyer);
    }


    public void recordSelling() {
        if (!customer.alreadyRecordedSelling()) {
            customer.addSelling(this);
            customer.setAlreadyRecordedSelling(true);
            Purchase correspondingPurchase = new Purchase(
                getProductId(),
                getUnitPriceWithoutTax(),
                getQuantity(),
                getTaxRate(),
                getCustomer(),
                getCompany()
            );
            customer.addPurchase(correspondingPurchase);
            customer.setAlreadyRecordedSelling(false);
        }
    }
}
