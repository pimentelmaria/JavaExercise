import java.util.List;

public class Main {
    
    public static void main(String[] args) {

        // Singular People
        Users.SingularPerson person1 = new Users.SingularPerson("Jajão", "jajao@example.com", "123456789");
        Users.SingularPerson person2 = new Users.SingularPerson("C4PedroBaby", "c4pedrobb@example.com", "987654321");

        // Companies
        Users.Company company1 = new Users.Company("Vaultec", "info@vaultec.com", "983333321");
        Users.Company company2 = new Users.Company("Feel Good Inc.", "uhuh@feelgoodinc.com", "987444421");

        // Purchases
        Sales.Purchase purchase1 = new Sales.Purchase("ProductX", 50.0, 2, 0.23, person1, company1);
        purchase1.recordPurchase();
        Sales.Purchase purchase2 = new Sales.Purchase("ProductY", 30.0, 1, 0.23, person1, company2);
        purchase2.recordPurchase();

        // Sellings
        Sales.Selling selling1 = new Sales.Selling("ProductA", 10.0, 5, 0.23, company2, person2);
        selling1.recordSelling();
        Sales.Selling selling2 = new Sales.Selling("ProductA", 10.0, 5, 0.23, company2, person1);
        selling2.recordSelling();


        // Output details to test
        System.out.println("\n" + person1.getName() + "'s List of Purchases:");
        for (Sales.Purchase purchase : person1.getPurchasesList()) {
            System.out.println("Product ID: " + purchase.getProductId());
            System.out.println("Unit Price Without Tax: " + purchase.getUnitPriceWithoutTax());
            System.out.println("Quantity: " + purchase.getQuantity());
            System.out.println("Tax Rate: " + purchase.getTaxRate());
            System.out.println("Customer: " + purchase.getCustomer().getName());
            System.out.println();
        }

        // Print the list of sellings
        System.out.println("\n" + person1.getName() + "'s Automatically Created List of Sellings:");
        for (Sales.Selling selling : person1.getSellingsList()) {
            System.out.println("Product ID: " + selling.getProductId());
            System.out.println("Unit Price Without Tax: " + selling.getUnitPriceWithoutTax());
            System.out.println("Quantity: " + selling.getQuantity());
            System.out.println("Tax Rate: " + selling.getTaxRate());
            System.out.println("Customer: " + selling.getCustomer().getName());
            System.out.println();
        }
        checkConsistency(person1);

        // Output details
        System.out.println("\n" + company1.getName() + "'s List of Sellings:");
        for (Sales.Selling selling : company1.getSellingsList()) {
            System.out.println("Product ID: " + selling.getProductId());
            System.out.println("Unit Price Without Tax: " + selling.getUnitPriceWithoutTax());
            System.out.println("Quantity: " + selling.getQuantity());
            System.out.println("Tax Rate: " + selling.getTaxRate());
            System.out.println("Customer: " + selling.getSingularPerson().getName());
            System.out.println();
        }

        // Print the list of sellings
        System.out.println("\n" + company2.getName() + "'s List of Sellings:");
        for (Sales.Selling selling : company2.getSellingsList()) {
            System.out.println("Product ID: " + selling.getProductId());
            System.out.println("Unit Price Without Tax: " + selling.getUnitPriceWithoutTax());
            System.out.println("Quantity: " + selling.getQuantity());
            System.out.println("Tax Rate: " + selling.getTaxRate());
            System.out.println("Customer: " + selling.getSingularPerson().getName());
            System.out.println();
        }

    }

    //To Develop: checkConsistency of Companies analogous to checkConsistency of SingularPerson
    public static void checkConsistency(Users.SingularPerson person) {
        List<Sales.Purchase> purchases = person.getPurchasesList();
        for (Sales.Purchase purchase : purchases) {
            boolean consistencyFound = false;
            for (Sales.Selling selling : purchase.getCustomer().getSellingsList()) {
                if (isConsistent(purchase, selling)) {
                    consistencyFound = true;
                    break;
                }
            }
            if (!consistencyFound) {
                System.out.println("Inconsistency found: Purchase " + purchase.getProductId() + " not matched with any Selling");
            }
        }

    }

    public static boolean isConsistent(Sales.Purchase purchase, Sales.Selling selling) {
        return purchase.getProductId().equals(selling.getProductId())
                && purchase.getUnitPriceWithoutTax() == selling.getUnitPriceWithoutTax()
                && purchase.getQuantity() == selling.getQuantity()
                && purchase.getTaxRate() == selling.getTaxRate()
                && purchase.getCustomer().getIdentificationNumber().equals(selling.getCustomer().getIdentificationNumber());
    }
    
}
