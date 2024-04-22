package Users;

import java.util.List;

public class SingularPerson extends Customer {
    private String nif;

    public SingularPerson(String name, String email, String nif) {
        super(name, email);
        this.nif = nif;
    }

    // Override the method to return the tax number (NIF)
    @Override
    public String getIdentificationNumber() {
        return nif;
    }

    public List<Sales.Purchase> getPurchasesList() {
        return purchases;
    }
}
