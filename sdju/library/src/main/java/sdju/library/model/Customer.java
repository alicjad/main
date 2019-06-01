package sdju.library.model;

public class Customer {

    private int customerId;
    private String customerName;
    private String emailAddress;
    private String phoneNumber;
    private boolean blockedAccount;

    public Customer(int customerId, String customerName, String emailAddress,
                    String phoneNumber, boolean blockedAccount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.blockedAccount = blockedAccount;
    }

    public Customer(){
        this.blockedAccount = false;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isBlockedAccount() {
        return blockedAccount;
    }

    public void setBlockedAccount(boolean blockedAccount) {
        this.blockedAccount = blockedAccount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", blockedAccount=" + blockedAccount +
                '}';
    }
}
