package Users;

import java.util.List;


public class Company extends Customer {
    private String nipc;

    public Company(String name, String email, String nipc) {
        super(name, email);
        this.nipc = nipc;
    }

    // Override the method to return the tax number (NIPC)
    @Override
    public String getIdentificationNumber()  {
        return nipc;
    }

    public List<Sales.Purchase> getPurchasesList() {
        return purchases;
    }
}
