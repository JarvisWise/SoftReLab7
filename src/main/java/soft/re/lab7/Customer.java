package soft.re.lab7;

public abstract class Customer {

    private String name;
    private String email;
    private Account account;

    public Customer(String name, String email, Account account) {
        this.name = name;
        this.email = email;
        this.account = account;
    }

    public abstract void withdraw(double sum, String currency);

    public String getFullName() {
        return getName() + " " + getSurname() + " ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {return account;}

    public abstract String getSurname();
}
