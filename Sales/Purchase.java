package Sales;

import Users.Customer;
import Users.Company;

public class Purchase extends Sale {

    public Purchase(String productId, double unitPriceWithoutTax, int quantity, double taxRate, Customer customer, Company seller) {
        super(productId, unitPriceWithoutTax, quantity, taxRate, customer, seller);
    }


    public void recordPurchase() {
        if (!customer.alreadyRecordedPurchase()) {
            customer.addPurchase(this);
            customer.setAlreadyRecordedPurchase(true);
            Selling correspondingSelling = new Selling(
                getProductId(),
                getUnitPriceWithoutTax(),
                getQuantity(),
                getTaxRate(),
                getCustomer(),
                getSingularPerson()
            );
            customer.addSelling(correspondingSelling);
            customer.setAlreadyRecordedPurchase(false);
        }
    }
}
