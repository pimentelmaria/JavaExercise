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
            // Set alreadyRecordedSelling to true to prevent recursive recording
            customer.setAlreadyRecordedSelling(true);
            // Create a corresponding purchase item
            Purchase correspondingPurchase = new Purchase(
                getProductId(),
                getUnitPriceWithoutTax(),
                getQuantity(),
                getTaxRate(),
                getCustomer(),
                getCompany()
            );
            // Add the corresponding purchase item to the list of purchases
            customer.addPurchase(correspondingPurchase);
            // Reset alreadyRecordedSelling flag
            customer.setAlreadyRecordedSelling(false);
        }
    }
}
