package soft.re.lab7;

public class CustomerPrinter {
    private Customer customer;

    public CustomerPrinter(Customer customer) {
        this.customer = customer;
    }

    public String printCustomerMoney() {
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + customer.getAccount().getIban() + ", Money: " + customer.getAccount().getMoney();
        return customer.getFullName() + accountDescription;
    }

    public String printCustomer() {
        return customer.getName() + " " + customer.getEmail();
    }
}
